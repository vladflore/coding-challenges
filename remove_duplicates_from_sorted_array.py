def remove_duplicates(numbers: list[int]) -> int:
    if not numbers:
        return 0

    position = 1
    for index in range(1, len(numbers)):
        if numbers[index] != numbers[position - 1]:
            numbers[position] = numbers[index]
            position += 1
    return position


if __name__ == '__main__':
    assert 2 == remove_duplicates([1,1,2])
    assert 5 == remove_duplicates([0,0,1,1,1,2,2,3,3,4])
