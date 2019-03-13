import java.util.ArrayList;
import java.util.List;

public class A257_BinaryTreePaths {
    public static void main(String[] args) {
        A257_BinaryTreePaths solution = new A257_BinaryTreePaths();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        List<String> output = solution.binaryTreePaths(tree);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(result, "", root);
        return result;
    }

    // WARNING: DO NOT USE StringBuilder, since it will not remove temp result in recursion stack when backtracking
    public void dfs(List<String> result, String str, TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        if (curNode.left == null && curNode.right == null) {
            result.add(str + curNode.val);
            return;
        }

        str += curNode.val + "->";
        dfs(result, str, curNode.left);
        dfs(result, str, curNode.right);
    }
}
