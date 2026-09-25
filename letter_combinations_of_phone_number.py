def letter_combinations(digits): 

    if not digits:
        return []

    digit_to_letters = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz'
    }

    result_combinations = ['']

    for digit in digits:
        new_combinations = []

        for combination in result_combinations:

            for letter in digit_to_letters[digit]:
                new_combinations.append(combination + letter)

        result_combinations = new_combinations

    return result_combinations


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check("letter_combinations('23')", letter_combinations('23'), ['ad', 'ae', 'af', 'bd', 'be', 'bf', 'cd', 'ce', 'cf']),
        check("letter_combinations('')", letter_combinations(''), []),
        check("letter_combinations('2')", letter_combinations('2'), ['a', 'b', 'c']),
        check("len(letter_combinations('79'))", len(letter_combinations('79')), 16),
    ]
    print(f"{sum(results)}/{len(results)} passed")
