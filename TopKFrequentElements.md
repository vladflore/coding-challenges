### Statement

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements. You may return the answer in any order.

Example: `nums = [1, 1, 1, 2, 2, 3]`, `k = 2` gives `[1, 2]`.

### Solution

Both approaches start by counting how often each number occurs with a hash map.

The bucket-sort approach creates an array of lists indexed by frequency (a number can occur at most `n` times, so `n + 1` buckets suffice) and puts every number into the bucket of its frequency. Walking the buckets from the highest frequency down and collecting numbers until we have `k` gives the answer in O(n) time.

The heap approach keeps a min-heap ordered by frequency with at most `k` numbers, dropping the least frequent one whenever it grows beyond `k`. That takes O(n log k) time. Both use O(n) extra space for the counts.
