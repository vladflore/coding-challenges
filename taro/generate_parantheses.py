def generate_parantheses(number_of_pairs: int) -> list[str]:
    valid_combinations = []

    def build_combinations(
        current_string, open_parantheses_needed, closed_parantheses_needed
    ):
        print(current_string)
        
        if len(current_string) == 2 * number_of_pairs:
            valid_combinations.append(current_string)
            return

        if open_parantheses_needed > 0:
            build_combinations(
                current_string + "(",
                open_parantheses_needed - 1,
                closed_parantheses_needed,
            )

        if closed_parantheses_needed > open_parantheses_needed:
            build_combinations(
                current_string + ")",
                open_parantheses_needed,
                closed_parantheses_needed - 1,
            )

    build_combinations("", number_of_pairs, number_of_pairs)

    return valid_combinations


if __name__ == "__main__":
    # ["((()))","(()())","(())()","()(())","()()()"]
    print(generate_parantheses(3))

    # ["()"]
    print(generate_parantheses(1))
