def longest_palindrome_substring(input_string: str) -> str:
    longest_palindrome = ""
    input_string_length = len(input_string)

    def is_palindrome(left: int, right: int) -> str:
        nonlocal longest_palindrome
        while (
            left >= 0
            and right < input_string_length
            and input_string[left] == input_string[right]
        ):
            current_palindrome = input_string[left : right + 1]
            if len(current_palindrome) > len(longest_palindrome):
                longest_palindrome = current_palindrome
            left -= 1
            right += 1
        return longest_palindrome

    for i in range(input_string_length):
        # check for odd length palindromes
        is_palindrome(i, i)

        # check for even length palindromes
        is_palindrome(i, i + 1)

    return longest_palindrome


if __name__ == "__main__":
    # "aba" is also valid
    assert "bab" == longest_palindrome_substring("babad")

    assert "bb" == longest_palindrome_substring("cbbd")

    assert "xyzzzyx" == longest_palindrome_substring("abcddcbxyzzzyx")
