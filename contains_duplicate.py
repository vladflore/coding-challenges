def contains_duplicate(numbers: list[int]) -> bool:
    if not numbers:
        return False

    seen = set()
    for number in numbers:
        if number in seen:
            return True
        seen.add(number)

    return False


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check('contains_duplicate([1, 2, 3, 1])', contains_duplicate([1, 2, 3, 1]), True),
        check('contains_duplicate([1, 2, 3, 4])', contains_duplicate([1, 2, 3, 4]), False),
        check('contains_duplicate([])', contains_duplicate([]), False),
        check('contains_duplicate([7])', contains_duplicate([7]), False),
        check('contains_duplicate([1, 1])', contains_duplicate([1, 1]), True),
    ]
    print(f"{sum(results)}/{len(results)} passed")
