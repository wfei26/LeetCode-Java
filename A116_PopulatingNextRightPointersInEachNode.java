public class A116_PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        A116_PopulatingNextRightPointersInEachNode solution = new A116_PopulatingNextRightPointersInEachNode();
        int[] myInputs = {1,2,3,4,5,6,7};
        TreeLinkNode myTree = solution.sortedArrayToBST(myInputs);
        solution.connect(myTree);
    }

    public TreeLinkNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
        }
        TreeLinkNode newTree = helpers(nums, 0, nums.length - 1);
        return newTree;
    }

    public TreeLinkNode helpers(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeLinkNode newNode = new TreeLinkNode(num[mid]);
        newNode.left = helpers(num, low, mid - 1);
        newNode.right = helpers(num, mid + 1, high);
        return newNode;
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        //initialize a parent pointer to point the parent node of current traversed level
        TreeLinkNode parent = root;
        //initialize a pointer to traverse linked list inside of each parent level
        TreeLinkNode curPtr;
        while (parent.left != null) {
            curPtr = parent;
            while (curPtr != null) {
                //populating left node to right node with same parent
                curPtr.left.next = curPtr.right;
                if (curPtr.next != null) {
                    //populating right node of current parent to left node of next parent
                    curPtr.right.next = curPtr.next.left;
                }
                //move current pointer to next node of current level
                curPtr = curPtr.next;
            }
            //move parent pointer to its left most child (in order to start to deal with next level)
            parent = parent.left;
        }
    }

    class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        TreeLinkNode(int x) {val = x;}
    }
}
