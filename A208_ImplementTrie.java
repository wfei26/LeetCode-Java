public class A208_ImplementTrie {
    public static void main(String[] args) {
        A208_ImplementTrie trie = new A208_ImplementTrie();
        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public A208_ImplementTrie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curTrieNode = root;
        for (char c : word.toCharArray()) {
            // if current trie node does not exist, create a new node
            if (curTrieNode.children[c - 'a'] == null) {
                curTrieNode.children[c - 'a'] = new TrieNode(c);
            }
            // traverse to its next child
            curTrieNode = curTrieNode.children[c - 'a'];
        }
        // set input word as correct word (searchable) in trie
        curTrieNode.isCorrectWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curTrieNode = root;
        for (char c : word.toCharArray()) {
            if (curTrieNode.children[c - 'a'] == null) {
                return false;
            }
            curTrieNode = curTrieNode.children[c - 'a'];
        }
        // different with the function "startsWith", we need to check if current TrieNode is a valid word
        // in trie dictionary, we do not want a intermediate node in the trie
        return curTrieNode.isCorrectWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curTrieNode = root;
        for (char c : prefix.toCharArray()) {
            if (curTrieNode.children[c - 'a'] == null) {
                return false;
            }
            curTrieNode = curTrieNode.children[c - 'a'];
        }
        // same as search() except for return value
        return true;
    }
}

class TrieNode {
    char val;
    boolean isCorrectWord;
    TrieNode[] children = new TrieNode[26];

    public TrieNode(char c) {
        val = c;
        isCorrectWord = false;
    }
}
