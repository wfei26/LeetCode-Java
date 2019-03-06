public class A079_WordSearch {
    public static void main(String[] args) {
        A079_WordSearch solution = new A079_WordSearch();
        char[][] input = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        boolean output = solution.exist(input, "ABCCED");
        System.out.println(output);
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }

        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if current character is the starting character of input word, start dfs
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, visited, word, n, m, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int n, int m, int x, int y, int index) {
        // recursion exit 1: when find word
        if (index == word.length()) {
            return true;
        }

        // recursion exit 2: when current point is out of bound of visited before or not the correct character
        // in current index, return false and backtrack
        if (x < 0 || x > n - 1 || y < 0 || y > m - 1 || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        visited[x][y] = true;
        boolean exist = dfs(board, visited, word, n, m, x + 1, y, index + 1)
                || dfs(board, visited, word, n, m, x - 1, y, index + 1)
                || dfs(board, visited, word, n, m, x, y + 1, index + 1)
                || dfs(board, visited, word, n, m, x, y - 1, index + 1);

        // WARNING: DO NOT FORGET to mark current point back to FALSE, in order to free this point for other searching path
        visited[x][y] = false;
        return exist;
    }
}
