### Statement

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`. You can return the answer in any order.

### Solution

The key insight is to use a hash map (dictionary) to store numbers we've already seen along with their indices. As we iterate through the array, for each number we check if its complement (target - current number) exists in our hash map.
