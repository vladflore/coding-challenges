### Statement

Given an integer array, move all `0`s to the end while keeping the relative order of the non-zero elements. Do it in place.

Example: `[0, 1, 0, 3, 12]` becomes `[1, 3, 12, 0, 0]`.

### Solution

We use two pointers: `walk` visits every element, and `pos` marks where the next non-zero element should go. Whenever `walk` finds a non-zero element, we swap it into position `pos` and advance `pos`. Non-zero elements keep their order because they are placed left to right in the order they are found, and the zeros end up behind them.

Time complexity is O(n) and extra space is O(1).
