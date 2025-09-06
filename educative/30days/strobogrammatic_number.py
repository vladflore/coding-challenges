def is_strobogrammatic(num):
    '''
    Given a string num representing an integer, determine whether it is a strobogrammatic number. Return TRUE if the number is strobogrammatic or FALSE if it is not.
    A strobogrammatic number appears the same when rotated 180 degrees (viewed upside down). For example, “69” is strobogrammatic because it looks the same when flipped upside down, while “962” is not.
    '''
    valid_pairs = {
        '0':'0',
        '1':'1',
        '6':'9',
        '8':'8',
        '9':'6'
    }
    
    left = 0
    right = len(num) - 1
    
    while left < right:
        if num[left] not in valid_pairs or num[right] != valid_pairs[num[left]]:
            return False
        left += 1
        right -= 1
    return True
