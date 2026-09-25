### Statement

Given an array of `intervals` where `intervals[i] = [start, end]`, merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example: `[[1, 3], [2, 6], [8, 10], [15, 18]]` gives `[[1, 6], [8, 10], [15, 18]]`. Intervals that only touch, like `[1, 4]` and `[4, 5]`, are merged too.

### Solution

We first sort the intervals by their start. After sorting, an interval can only overlap with the one directly before it in the result. We keep the last merged interval: if the next interval starts at or before its end, the two overlap and we extend the end to the larger of both ends; otherwise the next interval starts a new group and is added to the result.

Sorting dominates, so the time complexity is O(n log n); the result list takes O(n) space.
