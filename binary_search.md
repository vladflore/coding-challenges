### Statement

Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

### Solution

To solve the problem of searching for a target value in a sorted array, we can use the binary search algorithm. This algorithm works by repeatedly dividing the search interval in half. If the value of the search key is less than the item in the middle of the interval, we narrow the interval to the lower half. Otherwise, we narrow it to the upper half. We continue this process until we find the target value or determine that it is not present in the array.

