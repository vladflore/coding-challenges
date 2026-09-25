from collections import Counter, defaultdict


def are_anagrams(word1: str, word2: str) -> bool:
    if len(word1) != len(word2):
        return False

    freq_word1 = defaultdict(int)
    freq_word2 = defaultdict(int)

    for letter in word1:
        freq_word1[letter] += 1

    for letter in word2:
        freq_word2[letter] += 1

    return freq_word1 == freq_word2


def are_anagrams2(word1: str, word2: str) -> bool:
    return Counter(word1) == Counter(word2)


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check("are_anagrams('anagram', 'nagaram')", are_anagrams('anagram', 'nagaram'), True),
        check("are_anagrams('rat', 'car')", are_anagrams('rat', 'car'), False),
        check("are_anagrams('', '')", are_anagrams('', ''), True),
        check("are_anagrams('a', 'ab')", are_anagrams('a', 'ab'), False),
        check("are_anagrams('aab', 'abb')", are_anagrams('aab', 'abb'), False),
        check("are_anagrams2('anagram', 'nagaram')", are_anagrams2('anagram', 'nagaram'), True),
        check("are_anagrams2('rat', 'car')", are_anagrams2('rat', 'car'), False),
        check("are_anagrams2('', '')", are_anagrams2('', ''), True),
        check("are_anagrams2('a', 'ab')", are_anagrams2('a', 'ab'), False),
        check("are_anagrams2('aab', 'abb')", are_anagrams2('aab', 'abb'), False),
    ]
    print(f"{sum(results)}/{len(results)} passed")
