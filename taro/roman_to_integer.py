def roman_to_integer(roman_string: str) -> int:
    roman_values = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    }

    value = 0
    previous_value = 0

    for i, roman_char in enumerate(roman_string):
        current_value = roman_values[roman_char]
        if current_value > previous_value and i > 0:
            value += current_value - 2 * previous_value
        else:
            value += current_value

        previous_value = current_value

    return value


if __name__ == '__main__':
    print(f'III -> {roman_to_integer("III")}')
    print(f'LVIII -> {roman_to_integer("LVIII")}')
    print(f'MCMXCIV -> {roman_to_integer("MCMXCIV")}')
