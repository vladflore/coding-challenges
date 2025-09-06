def findRepeatedDnaSequences(s):
    '''
    Given a string, s, that represents a DNA sequence, return all the 10-letter-long sequences (continuous substrings of exactly 10 characters) that appear more than once in s. You can return the output in any order.

    Input: "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    Expected: ["AAAAACCCCC","CCCCCAAAAA"]
    '''
    seen = set()
    repeated_sequences = set()
    
    for i in range(len(s) - 9):
        sub = s[i:i + 10]
        if sub in seen:
            repeated_sequences.add(sub)
        else:
            seen.add(sub)
            
    return list(repeated_sequences)
