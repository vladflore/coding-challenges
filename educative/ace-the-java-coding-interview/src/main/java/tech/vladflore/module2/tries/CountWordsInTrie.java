package tech.vladflore.module2.tries;

import java.util.Arrays;

public class CountWordsInTrie {
    public static void main(String[] args) {
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "abc"};
        System.out.println("Keys: " + Arrays.toString(keys));
        Trie t = new Trie();
        for (String key : keys) t.insert(key);
        System.out.println(totalWords(t.getRoot()));
    }

    public static int totalWords(TrieNode root) {
        int result = root.isEndWord ? 1 : 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                result += totalWords(root.children[i]);
            }
        }
        return result;
    }
}
