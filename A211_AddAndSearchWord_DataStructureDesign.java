public class A211_AddAndSearchWord_DataStructureDesign {
    public static void main(String[] args) {
        A211_AddAndSearchWord_DataStructureDesign solution = new A211_AddAndSearchWord_DataStructureDesign();
        solution.addWord("bad");
        solution.addWord("dad");
        solution.addWord("mad");
        boolean output1 = solution.search("pad");
        boolean output2 = solution.search("bad");
        boolean output3 = solution.search(".ad");
        boolean output4 = solution.search("b..");
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
        System.out.println(output4);
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public A211_AddAndSearchWord_DataStructureDesign() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. Build trie */
    public void addWord(String word) {
        TrieNode curNode = root;
        for (char c : word.toCharArray()) {
            if (curNode.children[c - 'a'] == null) {
                curNode.children[c - 'a'] = new TrieNode();
            }
            curNode = curNode.children[c - 'a'];
        }
        curNode.word = word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    /** use dfs to check if we could match the input word in trie */
    public boolean match(char[] word, int index, TrieNode curNode) {
        if (index == word.length) {
            // WARNING: we CANNOT return true directly at here, since we need to check it our trie contains this word
            return !curNode.word.equals("");
        }
        if (word[index] != '.') {
            return (curNode.children[word[index] - 'a'] != null)
                    && match(word, index + 1, curNode.children[word[index] - 'a']);
        }
        // if current character is '.', we need to skip current level, and then check if we could match the rest of word
        // by traverse all possible children
        else {
            // if any branch of the trie return true, then we can find the word in trie
            for (int i = 0; i < curNode.children.length; i++) {
                if (curNode.children[i] != null && match(word, index + 1, curNode.children[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            word = "";
        }
    }
}
