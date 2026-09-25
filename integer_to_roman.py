def integer_to_roman(number: int) -> str:
    roman = ""

    integer_to_roman = {
        1: "I",
        4: "IV",
        5: "V",
        9: "IX",
        10: "X",
        40: "XL",
        50: "L",
        90: "XC",
        100: "C",
        400: "CD",
        500: "D",
        900: "CM",
        1000: "M",
    }

    integers = list(integer_to_roman.keys())
    integers.sort(reverse=True)

    for integer in integers:
        while number >= integer:
            roman += integer_to_roman[integer]
            number -= integer

    return roman


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check('integer_to_roman(3)', integer_to_roman(3), 'III'),
        check('integer_to_roman(4)', integer_to_roman(4), 'IV'),
        check('integer_to_roman(58)', integer_to_roman(58), 'LVIII'),
        check('integer_to_roman(1994)', integer_to_roman(1994), 'MCMXCIV'),
        check('integer_to_roman(3999)', integer_to_roman(3999), 'MMMCMXCIX'),
    ]
    print(f"{sum(results)}/{len(results)} passed")
