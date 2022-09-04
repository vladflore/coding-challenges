package tech.vladflore.module2.tries;

public class TrieNode {
    TrieNode[] children;
    boolean isEndWord;
    private static final int ALPHABET_SIZE = 26;

    TrieNode() {
        this.children = new TrieNode[ALPHABET_SIZE];
        this.isEndWord = false;
    }

    public void markAsLeaf() {
        this.isEndWord = true;
    }

    public void unMarkAsLeaf() {
        this.isEndWord = false;
    }
}
