from collections import defaultdict


def group_anagrams(words: list[str]) -> list[list[str]]:
    groups = defaultdict(list)

    for word in words:
        sorted_word = tuple(sorted(word))
        groups[sorted_word].append(word)

    return list(groups.values())


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


def normalized(groups):
    """Groups can come in any order, and so can the words inside a group."""
    return sorted(sorted(group) for group in groups)


if __name__ == "__main__":
    results = [
        check("group_anagrams(['eat', 'tea', 'tan', 'ate', 'nat', 'bat'])", normalized(group_anagrams(['eat', 'tea', 'tan', 'ate', 'nat', 'bat'])), [['ate', 'eat', 'tea'], ['bat'], ['nat', 'tan']]),
        check("group_anagrams([''])", normalized(group_anagrams([''])), [['']]),
        check("group_anagrams(['a'])", normalized(group_anagrams(['a'])), [['a']]),
        check('group_anagrams([])', normalized(group_anagrams([])), []),
        check("group_anagrams(['ab', 'ba', 'abc'])", normalized(group_anagrams(['ab', 'ba', 'abc'])), [['ab', 'ba'], ['abc']]),
    ]
    print(f"{sum(results)}/{len(results)} passed")
