def move_zeros(numbers:list[int]) -> list[int]:

    pos, walk = 0, 0
    while walk < len(numbers):
        if numbers[walk] != 0:
            numbers[walk], numbers[pos] = numbers[pos], numbers[walk]
            pos += 1
        walk += 1
    return numbers


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check('move_zeros([0, 1, 0, 3, 12])', move_zeros([0, 1, 0, 3, 12]), [1, 3, 12, 0, 0]),
        check('move_zeros([1, 2, 0, 3, 4])', move_zeros([1, 2, 0, 3, 4]), [1, 2, 3, 4, 0]),
        check('move_zeros([0, 0, 0, 1, 2])', move_zeros([0, 0, 0, 1, 2]), [1, 2, 0, 0, 0]),
        check('move_zeros([1, 2, 0])', move_zeros([1, 2, 0]), [1, 2, 0]),
        check('move_zeros([0])', move_zeros([0]), [0]),
        check('move_zeros([1])', move_zeros([1]), [1]),
        check('move_zeros([])', move_zeros([]), []),
    ]
    print(f"{sum(results)}/{len(results)} passed")
