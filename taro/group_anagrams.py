from collections import defaultdict

def group_anagrams(words: list[str]) -> list[list[str]]:
    groups = defaultdict(list)

    for word in words:
        sorted_word = tuple(sorted(word))
        groups[sorted_word].append(word)

    return list(groups.values())

def assert_equal_lists_ignore_order(l1:list[list[str]], l2:list[list[str]]) -> bool:
    set1 = {tuple(sorted(l)) for l in l1}
    set2 = {tuple(sorted(l)) for l in l2}
    assert set1 == set2


if __name__ == '__main__':
    actual = group_anagrams(["eat","tea","tan","ate","nat","bat"])
    print(actual)
    # assert actual == [[[["bat"],["nat","tan"],["ate","eat","tea"]]
    expected = [["bat"],["nat","tan"],["ate","eat","tea"]]
    assert_equal_lists_ignore_order(expected, actual)

    assert group_anagrams(['']) == [['']]
    assert group_anagrams(['a']) == [['a']]

