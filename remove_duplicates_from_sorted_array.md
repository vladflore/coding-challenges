### Statement

Given an integer array sorted in non-decreasing order, remove the duplicates in place so that each unique element appears only once, keeping their order. Return the number of unique elements `k`; the first `k` positions of the array must hold them.

Example: `[0, 0, 1, 1, 1, 2, 2, 3, 3, 4]` gives `5`, with the array starting `[0, 1, 2, 3, 4, ...]`.

### Solution

Because the array is sorted, duplicates are next to each other. A write pointer `position` marks where the next unique value goes; the first element is always kept. We scan the rest of the array, and whenever an element differs from the last value written (`numbers[position - 1]`), we write it at `position` and advance the pointer. At the end, `position` is the number of unique elements.

Time complexity is O(n) and extra space is O(1).
