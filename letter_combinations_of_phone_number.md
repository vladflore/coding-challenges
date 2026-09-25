### Statement

Given a string of digits from `2` to `9`, return all possible letter combinations the number could represent, using the letters on a telephone keypad (2 = abc, 3 = def, ..., 9 = wxyz). An empty input gives an empty list.

Example: `"23"` gives `["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]`.

### Solution

We build the combinations iteratively. Starting from a list containing the empty string, for each digit we create a new list by appending every letter of that digit to every combination built so far. After the last digit the list holds all combinations, in the order of the keypad letters.

With up to 4 letters per digit there are at most 4ⁿ combinations for `n` digits, so time and space are O(4ⁿ · n).
