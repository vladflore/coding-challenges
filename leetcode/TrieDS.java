package practice.leetcode;

public class TrieDS {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("vlad");
        trie.insert("vladut");
        trie.insert("flore");
        trie.insert("florea");
        System.out.println(trie.search("vladut"));
        System.out.println(trie.search("florea"));
        System.out.println(trie.search("flower"));
        System.out.println(trie.startsWith("flo"));
    }
}

class Trie {

    private Node root;

    public Trie() {
        root = new Node(('\0'));
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private Node getNode(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return null;
            }
            curr = curr.children[c - 'a'];
        }
        return curr;
    }
}

class Node {
    public char c;
    public boolean isWord;
    public Node[] children;

    public Node(char c) {
        this.c = c;
        isWord = false;
        children = new Node[26];
    }

}
