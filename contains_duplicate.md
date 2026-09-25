### Statement

Given an integer array `numbers`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

### Solution

We iterate through the array while keeping track of the elements we have seen so far using a set. If we encounter an element that is already in the set, we return `true`. If we finish iterating through the array without finding any duplicates, we return `false`.
