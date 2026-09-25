### Statement

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

### Solution

To solve this problem, we need to keep track of the last opened bracket and that when we encounter a closing bracket, it matches the last opened one. A stack data structure is perfect for this purpose.

We iterate through the string character by character and each time we encounter an opening bracket, we push it onto the stack. When we encounter a closing bracket, we check if the stack is not empty and if the top of the stack matches the corresponding opening bracket. If the stack is empty it means there is no matching opening bracket, and if the top of the stack does not match, it means the brackets are not in the correct order. In both cases, we return false. If we finish processing the string and the stack is empty, it means all brackets were matched correctly, and we return true.
