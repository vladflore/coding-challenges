from collections import defaultdict


def group_anagrams(words: list[str]) -> list[list[str]]:
    groups = defaultdict(list)

    for word in words:
        sorted_word = tuple(sorted(word))
        groups[sorted_word].append(word)

    return list(groups.values())


def equal_lists_of_lists(list1: list[list[str]], list2: list[list[str]]) -> bool:
    set1 = {tuple(sorted(inner_list)) for inner_list in list1}
    set2 = {tuple(sorted(inner_list)) for inner_list in list2}
    return set1 == set2


if __name__ == "__main__":
    expected = [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
    actual = group_anagrams(["eat", "tea", "tan", "ate", "nat", "bat"])
    assert equal_lists_of_lists(expected, actual)

    assert group_anagrams([""]) == [[""]]
    assert group_anagrams(["a"]) == [["a"]]
    assert group_anagrams(["ab", "ba"]) == [["ab", "ba"]]
