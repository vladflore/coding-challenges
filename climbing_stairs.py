def climbing_stairs(number_of_stairs: int) -> int:
    if number_of_stairs <= 2:
        return number_of_stairs

    first_step_ways = 1
    second_step_ways = 2

    for i in range(3, number_of_stairs + 1):
        current_step_ways = first_step_ways + second_step_ways
        first_step_ways = second_step_ways
        second_step_ways = current_step_ways

    return second_step_ways


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check('climbing_stairs(1)', climbing_stairs(1), 1),
        check('climbing_stairs(2)', climbing_stairs(2), 2),
        check('climbing_stairs(3)', climbing_stairs(3), 3),
        check('climbing_stairs(5)', climbing_stairs(5), 8),
        check('climbing_stairs(10)', climbing_stairs(10), 89),
    ]
    print(f"{sum(results)}/{len(results)} passed")
