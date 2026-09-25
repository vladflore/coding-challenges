### Statement

Given an array of strings, group the anagrams together. You can return the answer in any order.

### Solution

We can build a dictionary where the keys are the sorted versions of the strings, and the values are lists of strings that are anagrams of each other. Finally, we return the values of this dictionary as a list of lists.
