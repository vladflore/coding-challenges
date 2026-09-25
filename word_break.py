def word_break(phrase: str, dictionary: list[str]) -> bool:
    dictionary = set(dictionary)
    phrase_length = len(phrase)
    buildable = [False] * (phrase_length + 1)
    buildable[0] = True

    for i in range(1, phrase_length + 1):
        for j in range(i):
            if buildable[j] and phrase[j:i] in dictionary:
                buildable[i] = True
                break
    
    return buildable[phrase_length]


def check(label, actual, expected):
    ok = actual == expected
    print(f"{'PASS' if ok else 'FAIL'}  {label}" + ("" if ok else f"  -> expected {expected!r}, got {actual!r}"))
    return ok


if __name__ == "__main__":
    results = [
        check("word_break('leetcode', ['leet', 'code'])", word_break('leetcode', ['leet', 'code']), True),
        check("word_break('applepenapple', ['apple', 'pen'])", word_break('applepenapple', ['apple', 'pen']), True),
        check("word_break('catsandog', ['cats', 'dog', 'sand', 'and', 'cat'])", word_break('catsandog', ['cats', 'dog', 'sand', 'and', 'cat']), False),
        check("word_break('', ['a'])", word_break('', ['a']), True),
        check("word_break('a', [])", word_break('a', []), False),
    ]
    print(f"{sum(results)}/{len(results)} passed")
