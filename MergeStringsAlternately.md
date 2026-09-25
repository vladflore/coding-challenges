### Statement

You are given two strings `word1` and `word2`. Merge the strings by adding letters in alternating order, starting with `word1`. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the _merged_ string.

### Solution

To solve this problem, we can iterate through both strings simultaneously and append characters from each string to a result string. If one string is shorter than the other, we can append the remaining characters of the longer string after the loop.
