### Statement

Given the head of a singly linked list, reverse the list and return the new head.

Example: `1 -> 2 -> 3` becomes `3 -> 2 -> 1`.

### Solution

We walk through the list once, turning each `next` pointer around. Three references are needed: `previous` (the already reversed part, initially `None`), `current`, and the saved `next` node, because changing `current.next` would otherwise lose the rest of the list. For each node we save its next, point it to `previous`, then move `previous` and `current` one step forward. When `current` becomes `None`, `previous` is the new head.

Time complexity is O(n) and extra space is O(1).
