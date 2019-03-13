import java.util.ArrayList;
import java.util.List;

public class A113_PathSumII {
    public static void main(String[] args) {
        A113_PathSumII solution = new A113_PathSumII();
        int[] myInputs = {7,9,10,15,20};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        List<List<Integer>> myResults = solution.pathSum(myTree, 25);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j < myResults.get(i).size(); j++) {
                System.out.println(myResults.get(i).get(j));
            }
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
        }
        TreeNode newTree = helpers(nums, 0, nums.length - 1);
        return newTree;
    }

    public TreeNode helpers(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode newNode = new TreeNode(num[mid]);
        newNode.left = helpers(num, low, mid - 1);
        newNode.right = helpers(num, mid + 1, high);
        return newNode;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), sum, root);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> tempList, int sum, TreeNode curNode) {
        if (curNode == null) {
            return;
        }

        if (curNode.left == null && curNode.right == null && curNode.val == sum) {
            tempList.add(curNode.val);
            result.add(new ArrayList<>(tempList));
            // WARNING: DO NOT FORGET to remove the last adding element at here
            tempList.remove(tempList.size() - 1);
            return;
        }

        tempList.add(curNode.val);
        dfs(result, tempList, sum - curNode.val, curNode.left);
        dfs(result, tempList, sum - curNode.val, curNode.right);
        tempList.remove(tempList.size() - 1);
    }
}
