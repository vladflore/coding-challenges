### Statement

Given an array `prices` where `prices[i]` is the price of a given stock on the `i`-th day, you want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.

### Solution

To solve this problem, we need to find the day to buy the stock at the lowest price and the day to sell it at the highest price _after_ the buying day.

Note that the overall minimum price is not necessarily the best day to buy: in `[3, 8, 1, 2]` buying at 3 and selling at 8 beats anything after the minimum 1. What matters, for each selling day, is the lowest price seen *before* it.

We can achieve this by iterating through the list of prices while keeping track of the minimum price seen so far. When we encounter a price that is higher than the minimum price, we calculate the potential profit and update the maximum profit if this potential profit is greater than the current maximum profit.

Time complexity is O(n) and extra space is O(1).
