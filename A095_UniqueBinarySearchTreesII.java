import java.util.ArrayList;
import java.util.List;

public class A095_UniqueBinarySearchTreesII {
    public static void main (String[] args) {
        A095_UniqueBinarySearchTreesII solution = new A095_UniqueBinarySearchTreesII();
        List<TreeNode> outputs = solution.generateTrees(3);
        for (TreeNode tree : outputs) {
            System.out.println(tree.val);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
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

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> results = new ArrayList<>();
        if (n == 0) {
            return results;
        }
        return treeHelper(1, n);
    }

    public List<TreeNode> treeHelper(int start, int end) {
        List<TreeNode> newList = new ArrayList<>();

        //only if start is less than or equal to end, we can generate a subtree
        //if start is greater than end, we cannot generate a tree
        //so the recursion exit should be start > end, SMART!
        //then we should add null pointer to list and return the list in current recursion step
        if (start > end) {
            newList.add(null);
            return newList;
        }

        List<TreeNode> leftSubtrees, rightSubtrees;
        //i will be root of each subtree in every recursive call
        for (int i = start; i <= end; i++) {
            //all numbers smaller than i should generate left subtrees
            leftSubtrees = treeHelper(start, i - 1);
            //all numbers greater than i should generate right subtrees
            //since every number is unique, there does not exist duplicate number
            rightSubtrees = treeHelper(i + 1, end);

            //Use two nested loop to traverse all left subtrees and right subtrees
            //that generated from previous recursive calls, to make all possible
            //combinations to generate a bigger tree with new root i
            for (TreeNode leftSubtree : leftSubtrees) {
                for (TreeNode rightSubtree : rightSubtrees) {
                    TreeNode curRoot = new TreeNode(i);
                    curRoot.left = leftSubtree;
                    curRoot.right = rightSubtree;
                    newList.add(curRoot);
                }
            }
        }
        return newList;
    }
}
