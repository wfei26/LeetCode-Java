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
        if (board == null || board.length == 0) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ( dfs(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int count) {
        // recursion exit 1: when count number is equal to length, found it
        if (count == word.length()) {
            return true;
        }
        // recursion exit 2: when out of bound but still do not find the word, return false
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j]) {
            return false;
        }
        // recursion exit 3: if current search direction is not correct, backtracking
        if (board[i][j] != word.charAt(count)) {
            return false;
        }

        // DO NOT FORGET to mark visited characters
        visited[i][j] = true;

        // recursive steps, search four directions
        boolean exist = dfs(board, visited, word, i + 1, j, count + 1)
                || dfs(board, visited, word, i - 1, j, count + 1)
                || dfs(board, visited, word, i, j + 1, count + 1)
                || dfs(board, visited, word, i, j - 1, count + 1);

        // mark it back for next search
        visited[i][j] = false;
        return exist;
    }
}
