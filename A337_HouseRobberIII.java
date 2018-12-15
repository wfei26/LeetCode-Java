import java.util.HashMap;
import java.util.Map;

public class A337_HouseRobberIII {
    public static void main(String[] args) {
        A337_HouseRobberIII solution = new A337_HouseRobberIII();

        TreeNode newTree = new TreeNode(3);
        newTree.left = new TreeNode(2);
        newTree.right = new TreeNode(3);
        newTree.left.right = new TreeNode(3);
        newTree.right.right = new TreeNode(1);

        int output = solution.rob(newTree);
        System.out.println(output);
    }


    public int rob(TreeNode root) {
        return dfs(root, new HashMap<>());
    }

    // dfs + memoization to reduce overlapping (redundant) calculation
    public int dfs(TreeNode curNode, Map<TreeNode, Integer> map) {
        // recursion exit
        if (curNode == null) {
            return 0;
        }
        // restore cache value from map if existed
        if (map.containsKey(curNode)) {
            return map.get(curNode);
        }

        int curVal = 0;
        // recursively calculate max value of left and right subtree from the third level
        if (curNode.left != null) {
            curVal += dfs(curNode.left.left, map) + dfs(curNode.left.right, map);
        }
        if (curNode.right != null) {
            curVal += dfs(curNode.right.left, map) + dfs(curNode.right.right, map);
        }

        // two options: start from root with every odd level, or start from second level with every even level
        curVal = Math.max(curNode.val + curVal, dfs(curNode.left, map) + dfs(curNode.right, map));

        // store in cache to reduce redundant calculation
        map.put(curNode, curVal);
        return curVal;
    }
}
