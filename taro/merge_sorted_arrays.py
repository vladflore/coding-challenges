def merge_sorted_arrays(arr1, arr1_len, arr2, arr2_len):
    '''
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
    '''

    arr1_p = arr1_len - 1
    arr2_p = arr2_len - 1
    merged_p = arr1_len + arr2_len - 1

    while arr1_p >= 0 and arr2_p >= 0:
        if arr1[arr1_p] > arr2[arr2_p]:
            arr1[merged_p] = arr1[arr1_p]
            arr1_p -= 1
        else:
            arr1[merged_p] = arr2[arr2_p]
            arr2_p -= 1
        merged_p -= 1

    while arr2_p >= 0:
        arr1[merged_p] = arr2[arr2_p]
        arr2_p -= 1
        merged_p -= 1



if __name__ == '__main__':
    arr1 = [1,2,3,0,0,0]
    merge_sorted_arrays(arr1,3,[2,5,6],3)
    print(arr1)

    arr1 = [1,2,3,0]
    merge_sorted_arrays(arr1,3,[6],1)
    print(arr1)

    arr1 = [1,2,3,0,0,0]
    merge_sorted_arrays(arr1,3,[6,7,8],3)
    print(arr1)

    arr1 = [6,7,8,0,0,0]
    merge_sorted_arrays(arr1,3,[1,2,3],3)
    print(arr1)
