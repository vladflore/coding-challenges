### Statement

You are given the heads of two sorted linked lists. Merge them into one sorted linked list and return its head.

Example: `1 -> 2 -> 4` and `1 -> 3 -> 4` give `1 -> 1 -> 2 -> 3 -> 4 -> 4`.

### Solution

A dummy head node makes it easy to append without special-casing the first node. While both lists have nodes left, we compare their current values, append a node with the smaller value to the result and advance in that list. When one list is exhausted, the remaining nodes of the other are appended. We return the node after the dummy head.

This implementation creates new nodes, so the input lists stay unchanged; the time complexity is O(n + m) and the new list takes O(n + m) space. Relinking the existing nodes instead would need only O(1) extra space.
