### Statement

Given an integer `n`, return the least number of perfect square numbers that sum to `n`.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
For example, `1`, `4`, `9`, and `16` are perfect squares while `3` and `11` are __not__.

### Solution

The solution uses dynamic programming to find the minimum number of perfect squares that add up to `n`.
An array `dp` is built where `dp[i]` stores the minimum number of squares needed to form `i`.
For each number `i`, the algorithm tries all perfect squares smaller than or equal to `i`.
It updates `dp[i]` by choosing the smallest value between its current value and `dp[i - square] + 1`.
The final answer is stored in `dp[n]`.

