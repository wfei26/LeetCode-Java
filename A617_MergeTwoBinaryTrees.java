public class A617_MergeTwoBinaryTrees {
    public static void main (String[] args) {
        A617_MergeTwoBinaryTrees solution = new A617_MergeTwoBinaryTrees();
        int[] myInputs = {1,2,3,4,5,6,7,8,9};
        TreeNode myTree1 = solution.sortedArrayToBST(myInputs);
        TreeNode myTree2 = solution.sortedArrayToBST(myInputs);
        TreeNode newTree = solution.mergeTrees(myTree1, myTree2);
        solution.printTree(newTree);
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

    public void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.println(node.val);
        printTree(node.right);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        int curVal = 0;
        if (t1 == null && t2 == null) {
            curVal = 0;
        }
        else if (t1 == null && t2 != null) {
            curVal = t2.val;
        }
        else if (t1 != null && t2 == null) {
            curVal = t1.val;
        }
        else {
            curVal = t1.val + t2.val;
        }

        TreeNode newNode = new TreeNode(curVal);
        if (t1 == null && t2 == null) {
            newNode.left = mergeTrees(null, null);
            newNode.right = mergeTrees(null, null);
        }
        else if (t1 == null && t2 != null) {
            newNode.left = mergeTrees(null, t2.left);
            newNode.right = mergeTrees(null, t2.right);
        }
        else if (t1 != null && t2 == null) {
            newNode.left = mergeTrees(t1.left, null);
            newNode.right = mergeTrees(t1.right, null);
        }
        else {
            newNode.left = mergeTrees(t1.left, t2.left);
            newNode.right = mergeTrees(t1.right, t2.right);
        }
        return newNode;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = (mergeTrees(t1.left, t2.left));
        t1.right = (mergeTrees(t1.right, t2.right));
        return t1;
    }
}
