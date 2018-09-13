import java.util.ArrayList;
import java.util.List;

public class A113_PathSumII {
    public static void main(String[] args) {
        A113_PathSumII solution = new A113_PathSumII();
        int[] myInputs = {7,9,10,15,20};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        List<List<Integer>> myResults = solution.pathSum(myTree, 19);
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
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        List<Integer> currentList = new ArrayList<>();
        pathSumHelper(root, sum, resultList, currentList);
        return resultList;
    }

    public void pathSumHelper(TreeNode root, int sum, List<List<Integer>> resultList, List<Integer> currentList) {
        if (root == null) {
            return;
        }
        currentList.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            resultList.add(new ArrayList<>(currentList));
            currentList.remove(currentList.size() - 1);
            return;
        }
        else {
            pathSumHelper(root.left, sum - root.val, resultList, currentList);
            pathSumHelper(root.right, sum - root.val, resultList, currentList);
        }
        currentList.remove(currentList.size() - 1);
    }
}
