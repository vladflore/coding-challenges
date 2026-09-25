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


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


def merged(arr1, arr1_len, arr2, arr2_len):
    """The function works in place; return arr1 so it can be checked."""
    merge_sorted_arrays(arr1, arr1_len, arr2, arr2_len)
    return arr1


if __name__ == "__main__":
    results = [
        check('merge_sorted_arrays([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3)', merged([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3), [1, 2, 2, 3, 5, 6]),
        check('merge_sorted_arrays([1, 2, 3, 0], 3, [6], 1)', merged([1, 2, 3, 0], 3, [6], 1), [1, 2, 3, 6]),
        check('merge_sorted_arrays([6, 7, 8, 0, 0, 0], 3, [1, 2, 3], 3)', merged([6, 7, 8, 0, 0, 0], 3, [1, 2, 3], 3), [1, 2, 3, 6, 7, 8]),
        check('merge_sorted_arrays([0], 0, [1], 1)', merged([0], 0, [1], 1), [1]),
        check('merge_sorted_arrays([1], 1, [], 0)', merged([1], 1, [], 0), [1]),
    ]
    print(f"{sum(results)}/{len(results)} passed")
