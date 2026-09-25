def roman_to_integer(roman_string: str) -> int:
    roman_values = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}

    value = 0
    previous_value = 0

    for _, roman_char in enumerate(roman_string):
        current_value = roman_values[roman_char]
        if current_value > previous_value:
            value += current_value - 2 * previous_value
        else:
            value += current_value

        previous_value = current_value

    return value


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check("roman_to_integer('III')", roman_to_integer('III'), 3),
        check("roman_to_integer('IV')", roman_to_integer('IV'), 4),
        check("roman_to_integer('LVIII')", roman_to_integer('LVIII'), 58),
        check("roman_to_integer('MCMXCIV')", roman_to_integer('MCMXCIV'), 1994),
        check("roman_to_integer('MMMCMXCIX')", roman_to_integer('MMMCMXCIX'), 3999),
    ]
    print(f"{sum(results)}/{len(results)} passed")
