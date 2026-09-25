### Statement

Given an array of characters `chars`, compress it in place: each group of consecutive repeating characters is written as the character, followed by the group's length if it is greater than 1. Lengths of 10 or more take one array element per digit. Return the new length of the array.

Example: `["a", "a", "b", "b", "c", "c", "c"]` gives `6`, with the array starting `["a", "2", "b", "2", "c", "3"]`.

### Solution

We use a read pointer and a write pointer. The read pointer finds the end of the current group of equal characters and counts its length. The write pointer then writes the character and, if the group is longer than one, each digit of the count. The compressed form of a group is never longer than the group itself, so writing never overtakes reading and the compression can safely happen in the same array.

Time complexity is O(n) and extra space is O(1).
