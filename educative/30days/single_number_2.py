def two_single_numbers(arr):
    xor_all = 0
    for num in arr:
        xor_all ^= num
    
    diff_bit = xor_all & -xor_all
    
    x, y = 0, 0
    for num in arr:
        if num & diff_bit:
            x ^= num
        else:
            y ^= num
    
    return [x, y]

