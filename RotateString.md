### Statement

Given two strings `s` and `goal`, return `true` if `s` can become `goal` after some number of shifts, where a shift moves the leftmost character of `s` to the rightmost position.

Example: `s = "abcde"`, `goal = "cdeab"` gives `true`; `goal = "abced"` gives `false`.

### Solution

Every rotation of `s` appears as a substring of `s + s`: for `"abcde"`, the string `"abcdeabcde"` contains `"bcdea"`, `"cdeab"` and so on. So after checking that both strings have the same length (otherwise no rotation can match), it is enough to check whether `s + s` contains `goal`.

The concatenation and the substring search take O(n) extra space and, in the worst case, O(n²) time with a simple search.
