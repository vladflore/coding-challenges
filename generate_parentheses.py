def generate_parentheses(number_of_pairs: int) -> list[str]:
    valid_combinations = []

    def build_combinations(
        current_string, open_parentheses_needed, closed_parentheses_needed
    ):
        if len(current_string) == 2 * number_of_pairs:
            valid_combinations.append(current_string)
            return

        if open_parentheses_needed > 0:
            build_combinations(
                current_string + "(",
                open_parentheses_needed - 1,
                closed_parentheses_needed,
            )

        if closed_parentheses_needed > open_parentheses_needed:
            build_combinations(
                current_string + ")",
                open_parentheses_needed,
                closed_parentheses_needed - 1,
            )

    build_combinations("", number_of_pairs, number_of_pairs)

    return valid_combinations


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check('generate_parentheses(1)', sorted(generate_parentheses(1)), ['()']),
        check('generate_parentheses(2)', sorted(generate_parentheses(2)), ['(())', '()()']),
        check('generate_parentheses(3)', sorted(generate_parentheses(3)), sorted(['((()))', '(()())', '(())()', '()(())', '()()()'])),
        check('len(generate_parentheses(4))', len(generate_parentheses(4)), 14),
    ]
    print(f"{sum(results)}/{len(results)} passed")
