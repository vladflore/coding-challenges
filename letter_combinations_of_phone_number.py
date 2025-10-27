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

if __name__ == '__main__':
    print(letter_combinations('23'))
    print(letter_combinations(''))
    print(letter_combinations('2'))
