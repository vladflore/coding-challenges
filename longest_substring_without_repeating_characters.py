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


if __name__ == '__main__':
    assert 3 == length_of_longest_substr_wo_repeating_chars("abcabcbb")
    assert 1 == length_of_longest_substr_wo_repeating_chars("bbbbb")
    assert 3 == length_of_longest_substr_wo_repeating_chars("pwwkew")
