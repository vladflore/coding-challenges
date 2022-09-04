package tech.vladflore.module2.tries;

public class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String key) {
        if (key == null) {
            System.out.println("Null keys are not allowed.");
            return;
        }
        key = key.toLowerCase();
        TrieNode current = root;
        for (int level = 0; level < key.length(); level++) {
            int index = getIndex(key.charAt(level));
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.markAsLeaf();
    }

    public boolean search(String key) {
        if (key == null) {
            return false;
        }
        key = key.toLowerCase();
        TrieNode current = root;
        for (int level = 0; level < key.length(); level++) {
            int index = getIndex(key.charAt(level));
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndWord;
    }

    private int getIndex(char c) {
        return c - 'a';
    }

    public TrieNode getRoot() {
        return root;
    }
}
