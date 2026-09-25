### Statement

You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order, and two integers `m` and `n`, the number of elements in each. Merge `nums2` into `nums1` as one sorted array, in place. `nums1` has length `m + n`: its first `m` elements are the ones to merge and the last `n` are zeros reserved for the result.

Example: `nums1 = [1, 2, 3, 0, 0, 0]`, `m = 3`, `nums2 = [2, 5, 6]`, `n = 3` gives `[1, 2, 2, 3, 5, 6]`.

### Solution

We fill `nums1` from the back, where the free space is, so no element is overwritten before it has been used. Three pointers point at the last real element of `nums1`, the last element of `nums2`, and the last position of the result. At each step the larger of the two current elements goes to the result position and its pointer moves left. When `nums2` runs out, the remaining elements of `nums1` are already in place; if `nums1` runs out first, the rest of `nums2` is copied over.

Time complexity is O(m + n) and extra space is O(1).
