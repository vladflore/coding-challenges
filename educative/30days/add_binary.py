def add_binary(str1, str2):
    '''
    Given two binary strings str1 and str2, return their sum as a binary string.

    '''
    i = len(str1) - 1
    j = len(str2) - 1
    carry = 0
    result = []
    while i >= 0 or j >= 0 or carry:
        bit1 = int(str1[i]) if i >= 0 else 0
        bit2 = int(str2[j]) if j >= 0 else 0
        total = bit1 + bit2 + carry
        result.append(str(total % 2))
        carry = total // 2
        i -= 1
        j -= 1
    return ''.join(reversed(result))
        

