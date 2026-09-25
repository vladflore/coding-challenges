### Statement

Given the array of integers `nums`, you will choose two different indices `i` and `j` of that array. Return the maximum value of `(nums[i]-1) * (nums[j]-1)`.

### Solution

Since all numbers are at least 1, the product `(a - 1) * (b - 1)` is largest for the two largest numbers `a` and `b`. We find them in a single pass, keeping track of the largest and second largest value seen so far, and return `(largest - 1) * (secondLargest - 1)`. No sorting is needed, so this is O(n) time and O(1) space.
