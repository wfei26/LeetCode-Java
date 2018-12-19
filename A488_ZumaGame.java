public class A488_ZumaGame {
    public static void main(String[] args) {
        A488_ZumaGame solution = new A488_ZumaGame();
        String input1 = "WWRRBBWW";
        String input2 = "WRBRW";
        int output = solution.findMinStep(input1, input2);
        System.out.println(output);
    }

    public int findMinStep(String board, String hand) {
        if (board == null || board.length() == 0 || hand.length() == 0) {
            return -1;
        }

        int[] map = new int[26];
        for (char bullet : hand.toCharArray()) {
            map[bullet - 'A']++;
        }
        int result = dfs(board, map);
        return result;
    }

    public int dfs(String board, int[] map) {
        if (board.length() == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < board.length()) {
            while (j < board.length() && board.charAt(i) == board.charAt(j)) {
                j++;
            }

            // calculate how many balls we need, in order to delete the current color
            // j - i is the count of same element
            int ballsNeeded = 3 - (j - i);
            int curColor = board.charAt(i) - 'A';

            // if we have enough balls on hand, then we can start deleting
            if (map[curColor] >= ballsNeeded) {
                String newBoard = update(board.substring(0, i) + board.substring(j));

                // before recursive call: update count of current color left on hand
                map[curColor] -= ballsNeeded;

                // recursive call
                int curRes = dfs(newBoard, map);

                // if current result is valid, update result value
                // WARNING: MUST use curRes >= 0, NOT > 0, since we want to start updating result
                // from the leaf level when curRes = 0
                if (curRes >= 0) {
                    result = Math.min(result, curRes + ballsNeeded);
                }

                // after recursive call: recover to previous status
                map[curColor] += ballsNeeded;
            }

            // DO NOT FORGET to update value of i, since we want to start from j now
            i = j;
        }
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    // Update the board by removing all consecutive 3+ balls.
    // "YWWRRRWWYY" -> "YWWWWYY" -> "YYY" -> ""
    public String update(String s) {
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }

            // when we jump out the loop, j != i, so we want delete the substring of i to j - 1
            if (j - i >= 3) {
                s = s.substring(0, i) + s.substring(j);
                i = 0;
            }
            else {
                i++;
            }
        }
        return s;
    }
}
