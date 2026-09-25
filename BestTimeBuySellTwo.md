### Statement

You are given an array `prices` where `prices[i]` is the price of a stock on day `i`. On each day you may buy and/or sell the stock, but you can hold at most one share at a time (you may buy and sell on the same day). Return the maximum profit you can achieve.

Example: `prices = [7, 1, 5, 3, 6, 4]` gives `7` (buy at 1, sell at 5, buy at 3, sell at 6).

### Solution

Since the number of transactions is unlimited, every price increase from one day to the next can be captured: buying on day `i - 1` and selling on day `i` whenever `prices[i] > prices[i - 1]`. Any longer rising run is just the sum of its daily increases, so we walk through the array once and add up all positive differences between consecutive days. Falling days contribute nothing.

Time complexity is O(n) and extra space is O(1).
