from collections import defaultdict, Counter


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

if __name__ == '__main__':
    s, t = "anagram", "nagaram"
    print(f'{s} - {t} - {are_anagrams(s, t)}')
    print(f'{s} - {t} - {are_anagrams2(s, t)}')

    s, t = "rat", "car"
    print(f'{s} - {t} - {are_anagrams(s, t)}')
    print(f'{s} - {t} - {are_anagrams2(s, t)}')

    s, t = "", ""
    print(f'{s} - {t} - {are_anagrams(s, t)}')
    print(f'{s} - {t} - {are_anagrams2(s, t)}')

    s, t = "abc", "ab"
    print(f'{s} - {t} - {are_anagrams(s, t)}')
    print(f'{s} - {t} - {are_anagrams2(s, t)}')

