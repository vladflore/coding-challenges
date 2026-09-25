### Statement

Given an integer array `nums` and an integer `k`, return the `k`-th largest element in the array. Note that it is the `k`-th largest element in sorted order, not the `k`-th distinct element.

Example: `nums = [3, 2, 1, 5, 6, 4]`, `k = 2` gives `5`.

### Solution

Two approaches are implemented. The simplest sorts the array and returns `nums[nums.length - k]`, which costs O(n log n).

The better one keeps a min-heap (`PriorityQueue`) of at most `k` elements: every number is added, and whenever the heap grows beyond `k` the smallest element is removed. After processing all numbers the heap holds the `k` largest values, and its top (the smallest of them) is the answer. This runs in O(n log k) time with O(k) extra space.
