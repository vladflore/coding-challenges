### Statement

Given an array `nums` of size `n`, return the majority element: the element that appears more than `⌊n / 2⌋` times. You may assume the majority element always exists.

Example: `[2, 2, 1, 1, 1, 2, 2]` gives `2`.

### Solution

We count the occurrences of each number with `collections.Counter` and return the number whose count is greater than `len(nums) // 2`.

This takes O(n) time and O(n) extra space for the counts. The Boyer-Moore voting algorithm solves it in O(1) space: it keeps one candidate and a counter, increasing the counter for equal elements and decreasing it for others, switching candidates when the counter drops to zero.
