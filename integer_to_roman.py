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


if __name__ == "__main__":
    assert "MMMDCCXLIX" == integer_to_roman(3749)
    assert "LVIII" == integer_to_roman(58)
    assert "MCMXCIV" == integer_to_roman(1994)
