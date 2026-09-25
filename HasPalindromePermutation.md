### Statement

Given a string, return `true` if some permutation of its characters forms a palindrome, and `false` otherwise.

Example: `"carerac"` gives `true` (it can be arranged as `"racecar"`), `"code"` gives `false`.

### Solution

In a palindrome every character appears an even number of times, except possibly one character in the middle. So we count how often each character occurs (here with a stream and `Collectors.groupingBy`) and count how many characters have an odd frequency. A palindrome permutation exists exactly when at most one character has an odd count.

Time complexity is O(n) and extra space is O(k) for the `k` distinct characters.
