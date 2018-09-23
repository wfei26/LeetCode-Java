public class A129_SumRootToLeafNumbers {
    public static void main(String[] args) {
        A129_SumRootToLeafNumbers solution = new A129_SumRootToLeafNumbers();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        int output = solution.sumNumbers(myTree);
        System.out.println(output);
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

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = dfsSum(root, 0);
        return result;
    }

    public int dfsSum(TreeNode curNode, int sum) {
        if (curNode == null) {
            return 0;
        }
        //exit: last level still do the same thing as well (DO NOT FORGET!!!)
        if (curNode.left == null && curNode.right == null) {
            return sum * 10 + curNode.val;
        }
        //the sum until current level is equal to previous sum * 10 + curNode value
        //then we need to use dfs to trace both of left and right subtree for each level
        return dfsSum(curNode.left, sum * 10 + curNode.val) + dfsSum(curNode.right, sum * 10 + curNode.val);
    }
}
