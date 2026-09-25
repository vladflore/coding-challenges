def longest_palindrome_substring(input_string: str) -> str:
    longest_palindrome = ""
    input_string_length = len(input_string)

    def expand_around_center(left: int, right: int) -> None:
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

    for i in range(input_string_length):
        # check for odd length palindromes
        expand_around_center(i, i)

        # check for even length palindromes
        expand_around_center(i, i + 1)

    return longest_palindrome


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check("longest_palindrome_substring('babad') in ('bab', 'aba')", longest_palindrome_substring('babad') in ('bab', 'aba'), True),
        check("longest_palindrome_substring('cbbd')", longest_palindrome_substring('cbbd'), 'bb'),
        check("longest_palindrome_substring('a')", longest_palindrome_substring('a'), 'a'),
        check("longest_palindrome_substring('')", longest_palindrome_substring(''), ''),
        check("longest_palindrome_substring('racecar')", longest_palindrome_substring('racecar'), 'racecar'),
        check("longest_palindrome_substring('abcddcbxyzzzyx')", longest_palindrome_substring('abcddcbxyzzzyx'), 'xyzzzyx'),
    ]
    print(f"{sum(results)}/{len(results)} passed")
