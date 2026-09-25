### Statement

You are climbing a staircase with `number_of_stairs` steps. Each time you can climb either 1 or 2 steps. In how many distinct ways can you reach the top?

Example: `3` stairs give `3` ways: 1+1+1, 1+2 and 2+1.

### Solution

To reach step `i`, the last move came either from step `i - 1` (a single step) or from step `i - 2` (a double step), so `ways(i) = ways(i - 1) + ways(i - 2)`: the Fibonacci recurrence. With `ways(1) = 1` and `ways(2) = 2` as the base cases, we build the answer bottom-up. Only the last two values are needed at any time, so we keep just two variables instead of a whole table.

Time complexity is O(n) and extra space is O(1).
