def reorganize_string(string: str) -> str:

    if not string:
        return ""

    from collections import defaultdict
    characters_count = defaultdict(int)
    for char in string:
        characters_count[char] += 1

    max_count = max(characters_count.values())
    if max_count > (len(string) + 1) // 2:
        return ""

    sorted_characters = sorted(characters_count.items(), key=lambda item:item[1], reverse=True)

    result = [''] * len(string)

    index = 0
    for char, count in sorted_characters:
        for _ in range(count):
            if index >= len(string):
                index = 1
            result[index] = char
            index += 2

    return ''.join(result)


if __name__ == "__main__":
    assert "aba" == reorganize_string("aab")
    assert "" == reorganize_string("aaab")
    assert "abaca" == reorganize_string("aaabc")
    assert "" == reorganize_string("")
