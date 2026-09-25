### Statement

Given a string, rearrange its characters so that no two adjacent characters are the same. Return any such arrangement, or `""` if it is not possible.

Example: `"aab"` gives `"aba"`, while `"aaab"` gives `""`.

### Solution

A valid arrangement exists only if no character appears more than `(n + 1) // 2` times; otherwise two copies of it would have to be adjacent, so we return `""`. If it is possible, we count the characters, sort them by frequency (most frequent first) and place them at the even indices 0, 2, 4, ... first, continuing at the odd indices 1, 3, 5, ... once the end is reached. Placing the most frequent character first guarantees it fits on the even positions, and copies of any character are always at least two positions apart.

Counting is O(n), sorting the `k` distinct characters O(k log k), and the result takes O(n) space.
