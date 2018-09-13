public class A100_SameTree {
    public static void main(String[] args) {
        A100_SameTree solution = new A100_SameTree();
        int[] myInputs1 = {1,2,1};
        int[] myInputs2 = {1,2,1};
        TreeNode myTree1 = solution.sortedArrayToBST(myInputs1);
        TreeNode myTree2 = solution.sortedArrayToBST(myInputs2);
        boolean myResult = solution.isSameTree(myTree1, myTree2);
        System.out.println(myResult);
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
