### Statement

Given an integer `n`, return a string array `answer` (**1**-indexed) where:

`answer[i] == "FizzBuzz"` if i is divisible by 3 and 5.
`answer[i] == "Fizz"` if i is divisible by 3.
`answer[i] == "Buzz"` if i is divisible by 5.
`answer[i] == i` (as a string) if none of the above conditions are true.

### Solution

To solve this problem, we can iterate through the numbers from 1 to `n` and apply the given conditions to determine what string to add to our answer array. We can use a simple loop and conditional statements to check for divisibility by 3 and 5. If a number is divisible by 3 we will add "Fizz" to the answer, if it is divisible by 5 we will add "Buzz", and if it is not divisible by either, we will add the number itself as a string. We then store the string result for number `i` in the `answer` array at index `i-1` (since the array is 0-indexed).
