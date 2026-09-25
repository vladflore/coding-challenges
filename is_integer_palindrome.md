### Statement

Given an integer x, return true if x is a palindrome, and false otherwise. An integer is a palindrome when it reads the same backward as forward.

### Solution

To solve this problem without converting the integer to a string or reversing the entire number, we can compare the _first half_ of the number with the _**reversed** second half_. If they are the same, then the number is a palindrome.

For even-length numbers, the halves will be of equal length. For odd-length numbers, we have to ignore the middle digit that appears in the second half.

An immediate check is to see if the number is negative or ends with a zero (but is not zero itself). In these cases, the number cannot be a palindrome.
