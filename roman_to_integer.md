### Statement

Given a roman numeral, convert it to an integer. The roman to integer mapping is as follows:

```python
    roman_values = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
```

### Solution

Converting a roman numeral to an integer involves iterating through the characters of the string and applying the rules of roman numeral representation. If a smaller numeral appears before a larger numeral, it is subtracted; otherwise, it is added.

For the case when subtraction is needed, we can check if the current numeral is greater than the previous numeral. If it is, we subtract twice the value of the previous numeral (once to negate the addition we did earlier and once more to account for the subtraction).
