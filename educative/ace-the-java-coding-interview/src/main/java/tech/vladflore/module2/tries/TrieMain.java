package tech.vladflore.module2.tries;

import java.util.Arrays;

public class TrieMain {
    public static void main(String[] args) {
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "abc"};
        String[] output = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();
        System.out.println("Keys: " + Arrays.toString(keys));
        for (String key : keys) {
            t.insert(key);
        }

        if (t.search("the")) {
            System.out.println("the --- " + output[1]);
        } else {
            System.out.println("the --- " + output[0]);
        }

        if (t.search("these")) {
            System.out.println("these --- " + output[1]);
        } else {
            System.out.println("these --- " + output[0]);
        }

        if (t.search("abc")) {
            System.out.println("abc --- " + output[1]);
        } else {
            System.out.println("abc --- " + output[0]);
        }
    }
}

