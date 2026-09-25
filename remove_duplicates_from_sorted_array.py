def remove_duplicates(numbers: list[int]) -> int:
    if not numbers:
        return 0

    position = 1
    for index in range(1, len(numbers)):
        if numbers[index] != numbers[position - 1]:
            numbers[position] = numbers[index]
            position += 1
    return position


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


def deduplicated(numbers):
    """Returns (k, first k elements): the function works in place."""
    k = remove_duplicates(numbers)
    return k, numbers[:k]


if __name__ == "__main__":
    results = [
        check('remove_duplicates([1, 1, 2])', deduplicated([1, 1, 2]), (2, [1, 2])),
        check('remove_duplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4])', deduplicated([0, 0, 1, 1, 1, 2, 2, 3, 3, 4]), (5, [0, 1, 2, 3, 4])),
        check('remove_duplicates([])', deduplicated([]), (0, [])),
        check('remove_duplicates([7])', deduplicated([7]), (1, [7])),
    ]
    print(f"{sum(results)}/{len(results)} passed")
