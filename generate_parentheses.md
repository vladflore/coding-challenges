### Statement

Given `number_of_pairs` pairs of parentheses, generate all combinations of well-formed parentheses.

Example: `3` gives `["((()))", "(()())", "(())()", "()(())", "()()()"]`.

### Solution

We build the strings with backtracking, one character at a time, keeping track of how many opening and closing parentheses are still available. An opening parenthesis can be added while some are left. A closing one can be added only if more closing than opening parentheses remain, which means there is an unmatched opening parenthesis to close. This way we never create an invalid prefix, and every string that reaches length `2 * n` is valid and gets collected.

The number of results is the n-th Catalan number, and the work is proportional to the number of results times their length.
