def length_of_longest_substr_wo_repeating_chars(string: str) -> int:
    chars_window = set()
    max_length = 0
    left = 0

    for right in range(len(string)):
        current = string[right]

        while current in chars_window:
            chars_window.remove(string[left])
            left += 1

        chars_window.add(current)
        length = right - left + 1
        max_length = max(max_length, length)


    return max_length


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check("length_of_longest_substr_wo_repeating_chars('abcabcbb')", length_of_longest_substr_wo_repeating_chars('abcabcbb'), 3),
        check("length_of_longest_substr_wo_repeating_chars('bbbbb')", length_of_longest_substr_wo_repeating_chars('bbbbb'), 1),
        check("length_of_longest_substr_wo_repeating_chars('pwwkew')", length_of_longest_substr_wo_repeating_chars('pwwkew'), 3),
        check("length_of_longest_substr_wo_repeating_chars('')", length_of_longest_substr_wo_repeating_chars(''), 0),
        check("length_of_longest_substr_wo_repeating_chars('au')", length_of_longest_substr_wo_repeating_chars('au'), 2),
        check("length_of_longest_substr_wo_repeating_chars('dvdf')", length_of_longest_substr_wo_repeating_chars('dvdf'), 3),
    ]
    print(f"{sum(results)}/{len(results)} passed")
