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
        //must satisfy both of null conditions
        if (p == null && q == null) {
            return true;
        }
        //if one node is null, but the other one is not null, return false
        if (p == null || q == null) {
            return false;
        }
        //if two nodes are same, recursively comparing both of left nodes and right nodes
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        //completed traversing for one tree, but another tree still have extra nodes
        //then default return false
        return false;
    }

}
