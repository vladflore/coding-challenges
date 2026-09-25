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


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


def is_valid_arrangement(result, original):
    """Any arrangement of the same characters with no two equal neighbours is accepted."""
    same_characters = sorted(result) == sorted(original)
    no_equal_neighbours = all(a != b for a, b in zip(result, result[1:]))
    return same_characters and no_equal_neighbours


if __name__ == "__main__":
    results = [
        check("reorganize_string('aab') is valid", is_valid_arrangement(reorganize_string('aab'), 'aab'), True),
        check("reorganize_string('aaabc') is valid", is_valid_arrangement(reorganize_string('aaabc'), 'aaabc'), True),
        check("reorganize_string('vvvlo') is valid", is_valid_arrangement(reorganize_string('vvvlo'), 'vvvlo'), True),
        check("reorganize_string('ab') is valid", is_valid_arrangement(reorganize_string('ab'), 'ab'), True),
        check("reorganize_string('aaab')", reorganize_string('aaab'), ''),
        check("reorganize_string('aa')", reorganize_string('aa'), ''),
        check("reorganize_string('')", reorganize_string(''), ''),
    ]
    print(f"{sum(results)}/{len(results)} passed")
