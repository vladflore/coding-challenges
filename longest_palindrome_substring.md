### Statement

Given a string, return the longest substring that is a palindrome. If there are several of the same length, any of them is accepted.

Example: `"babad"` gives `"bab"` (or `"aba"`), and `"cbbd"` gives `"bb"`.

### Solution

Every palindrome is symmetric around its center, which is either a single character (odd length) or the gap between two characters (even length). For each of the `2n - 1` possible centers we expand outwards while the characters on both sides are equal, and remember the longest palindrome found so far.

Each expansion takes up to O(n), so the time complexity is O(n²); apart from the result, extra space is O(1).
