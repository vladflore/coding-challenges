### Statement

Given two strings, return true if one is an anagram of the other, and false otherwise.

### Solution

We count the frequency of each character in both strings and compare the counts. If they match, the strings are anagrams. To build the frequency counts, we can use a dictionary where keys are characters and values are their respective counts.
