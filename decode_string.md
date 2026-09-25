### Statement

Given an encoded string, return its decoded form. The encoding rule is `k[encoded_string]`: the part inside the square brackets is repeated exactly `k` times. Encodings can be nested, and `k` can have several digits.

Example: `"3[a]2[bc]"` gives `"aaabcbc"`, and `"3[a2[c]]"` gives `"accaccacc"`.

### Solution

We scan the string once and use a stack to handle nesting. Digits build up the current repeat count. On `[` we push the pair (count, string built so far) onto the stack and start a fresh string for the bracket's content. On `]` we pop that pair and set the current string to the previous string followed by the bracket's content repeated count times. Any other character is appended to the current string.

The running time is proportional to the length of the decoded output, and the stack depth equals the nesting depth.
