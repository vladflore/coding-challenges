def move_zeros(numbers:list[int]) -> list[int]:

    pos, walk = 0, 0
    while walk < len(numbers):
        if numbers[walk] != 0:
            numbers[walk], numbers[pos] = numbers[pos], numbers[walk]
            pos += 1
        walk += 1
    return numbers

if __name__ == '__main__':
    print(move_zeros([0,1,0,3,12]))
    print(move_zeros([1,2,0,3,4]))
    print(move_zeros([0,0,0,1,2]))
    print(move_zeros([1,2,0]))
    print(move_zeros([0]))
    print(move_zeros([1]))
