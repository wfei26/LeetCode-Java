import java.util.HashMap;
import java.util.Map;

public class A294_FlipGameII {
    public static void main(String[] args) {
        A294_FlipGameII solution = new A294_FlipGameII();
        String input = "++++";
        boolean output = solution.canWin(input);
        System.out.println(output);
    }

    /**
     * The idea is try to replace every "++" in the current string s to "--" and see if the opponent can win or not,
     * if the opponent cannot win, great, we win! So we use DFS + Memo to solve the problem.
     *
     * Actually, we do not care which player can win for a specific string at each recursive round.
     * we only care if current player (does not matter if current player is you or your opponent)can win or not.
     * After recursively building the dfs tree, we will know the winning condition for every leaf node (still does not
     * care which player plays the last round on the leaf node), and then trace back by the bottom-up order.
     * If we can find a path that return true at the very top (this is the player condition that we only care, since we
     * assume we play first), then we can guarantee that there exist a way that first player can win
     * */
    Map<String, Boolean> map = new HashMap<>();
    public boolean canWin(String s) {
        // if we already traversed this path before, retrieve information from map directly
        if(map.get(s) != null)  {
            return map.get(s);
        }

        if(s.length() < 2)  {
            map.put(s, false);
            return false;
        }

        // try every possible string until find the leaf level for every possibility
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                // once we find one path that back to root, return directly
                if(!canWin(t)) {
                    map.put(s, true);
                    return map.get(s); // the opponent lose, means we win
                }
            }
        }
        // after traversing all characters of current string, if there is no two consecutive "+" in current string,
        // return false since current player cannot win in current string condition
        map.put(s, false);
        return false;
    }
}
