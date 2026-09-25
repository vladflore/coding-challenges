### Statement

Given a string, find the length of the longest substring that contains no repeating characters.

Example: `"abcabcbb"` gives `3` (`"abc"`), `"bbbbb"` gives `1`, and `"pwwkew"` gives `3` (`"wke"`).

### Solution

We use a sliding window, with a set holding the characters inside it. The right end moves forward one character at a time. If the new character is already in the window, we shrink the window from the left, removing characters from the set, until the duplicate is gone. Then we add the new character and update the best length seen so far.

Each character enters and leaves the window at most once, so the time complexity is O(n); the set holds at most one entry per distinct character.
