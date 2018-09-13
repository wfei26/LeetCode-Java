import java.util.ArrayList;
import java.util.List;

public class A366_FindLeavesOfBinaryTree {
    public static void main(String[] args) {
        A366_FindLeavesOfBinaryTree solution = new A366_FindLeavesOfBinaryTree();
        int[] myInputs = {1,2,3,4,5};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        List<List<Integer>> myResults = solution.findLeaves(myTree);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j <myResults.get(i).size(); j++) {
                System.out.println(myResults.get(i).get(j));
            }
            System.out.println("------------------------------");
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

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        findHeight(root, resultList);
        return resultList;
    }

    public int findHeight(TreeNode curNode, List<List<Integer>> myList) {
        if (curNode == null) {
            return -1; //null ptr should not add level by 1, so return -1 that plus 1 to 0
        }
        int level = 1 + Math.max(findHeight(curNode.left, myList), findHeight(curNode.right, myList));
        //eg:   lv2      1      lv1
        //              / \
        //      lv1    2   3    lv0
        //            / \
        //      lv0  4   5
        //if level equals to list size, we need to allocate a new sublist to add new leaves from upper level
        //otherwise, just directly add to one of exist sublist
        if (level == myList.size()) {
            myList.add(new ArrayList<>());
        }
        myList.get(level).add(curNode.val);
        return level;
    }
}
