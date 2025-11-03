def contains_duplicate(numbers: list[int]) -> bool:
    if not numbers:
        return False

    seen = set()
    for number in numbers:
        if number in seen:
            return True
        seen.add(number)

    return False


if __name__ == "__main__":
    assert contains_duplicate([1, 2, 3, 1])
    assert not contains_duplicate([1, 2, 3, 4])
    assert not contains_duplicate([])
