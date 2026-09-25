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

if __name__ == '__main__':
    s = "leetcode"
    dictionary = ["leet","code"]
    assert word_break(s, dictionary)

