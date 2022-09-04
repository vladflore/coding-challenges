package tech.vladflore.module2.tries;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllWordsInTrie {
    public static void main(String[] args) {
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "abc"};
        Trie t = new Trie();
        System.out.println("Keys: " + Arrays.toString(keys));
        for (String key : keys) t.insert(key);
        ArrayList<String> list = findAllWords(t.getRoot());
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static ArrayList<String> findAllWords(TrieNode root) {
        ArrayList<String> words = new ArrayList<>();
        char[] currentWord = new char[20];
        getWords(root, words, 0, currentWord);
        return words;
    }

    private static void getWords(TrieNode root, ArrayList<String> words, int level, char[] currentWord) {
        if (root.isEndWord) {
            words.add(String.copyValueOf(currentWord, 0, level));
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                currentWord[level] = (char) (i + 'a');
                getWords(root.children[i], words, level + 1, currentWord);
            }
        }
    }
}
