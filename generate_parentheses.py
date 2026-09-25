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


if __name__ == "__main__":
    # ["((()))","(()())","(())()","()(())","()()()"]
    print(generate_parentheses(3))

    # ["()"]
    print(generate_parentheses(1))
