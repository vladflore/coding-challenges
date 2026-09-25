### Statement

Given a string `phrase` and a list of words `dictionary`, return `true` if `phrase` can be split into a sequence of one or more dictionary words. The same word may be used several times.

Example: `"leetcode"` with `["leet", "code"]` gives `true`.

### Solution

We use dynamic programming: `buildable[i]` says whether the first `i` characters can be built from dictionary words, with `buildable[0] = true` for the empty prefix. For each end position `i` we look for a split point `j` such that the prefix up to `j` is buildable and the piece `phrase[j:i]` is a dictionary word; if one exists, `buildable[i]` is true. The answer is `buildable[n]`. The dictionary is turned into a set for O(1) lookups.

There are O(n²) pairs `(j, i)`, and each slice costs up to O(n), so the time complexity is O(n³) in the worst case; the table takes O(n) space.
