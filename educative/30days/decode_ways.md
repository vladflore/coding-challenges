Statement
Given a string that has only positive digits, your task is to decode the string and determine the number of possible ways to decode it.

Consider the input string as an encoded message, where each digit in the string represents an alphabet from A to Z. For reference, let’s look at the mapping below:

"1" represents "A"

"2" represents "B"

"3" represents "C"

…
…

"26" represents "Z"

How to perform the decode operation?

To decode an encoded message, we have to check whether or not each digit in the string can be mapped onto the mapping above. There can be multiple ways to decode a string.

For example, the string "231012" can be decoded in the following ways:

Option 1 
→
→
 "2", "3", "10", "1", "2" 
→
→
 "B", "C", "J", "A", "B"

Option 2 
→
→
 "2", "3", "10", "12" 
→
→
 "B", "C", "J", "L"

Option 3 
→
→
 "23", "10", "1", "2" 
→
→
 "W", "J", "A", "B"

Option 4 
→
→
 "23", "10", "12" 
→
→
 "W", "J", "L"

Note: In the mapping above, we haven't included "01" since it's an invalid mapping. It cannot be mapped onto "A" since "01" and "1" are different.
