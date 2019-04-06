import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A212_WordSearchII {
    public static void main(String[] args) {
        A212_WordSearchII solution = new A212_WordSearchII();
    }

    /**
     * Use Trie with backtracking to solve the problem. Trie will significantly improve algorithm efficiency, because
     * we have to search a lot of words, not a single word. The condition that we determine if we want to continue to
     * search on current recursion path is that whether current string is one of a prefix in Trie. TrieNode is like an
     * ordered tree data structure which is very helpful when it comes to storing strings that helps in quick search,
     * insert etc. reduce complexity from n * 2^n to 2^n
     *
     * For word search I, if we only need to search a single word, we can simply update string variable by
     * append every new character into previous string. However, for word search II, we have a list of words, if we do
     * not use trie, we do not know whether we want to continue to search
     * */
    public List<String> findWords(char[][] board, String[] words) {
        // build trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[m][n];

        // use every point as possible starting position, doing dfs to search whether we can find a correct candidate word
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(res, board, visited, "", i, j, trie);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(Set<String> result, char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return;
        }

        // if trie does not contain current prefix, terminate current recursion path
        str += board[x][y];
        if (!trie.startsWith(str)) {
            return;
        }

        if (trie.search(str)) {
            result.add(str);
        }

        // backtracking with four directions
        visited[x][y] = true;
        dfs(result, board, visited, str, x - 1, y, trie);
        dfs(result, board, visited, str, x + 1, y, trie);
        dfs(result, board, visited, str, x, y - 1, trie);
        dfs(result, board, visited, str, x, y + 1, trie);
        visited[x][y] = false;
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";

        public TrieNode() {}
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return node.item.equals(word);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return true;
        }
    }
}
