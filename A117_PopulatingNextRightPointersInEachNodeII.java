public class A117_PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {
        A117_PopulatingNextRightPointersInEachNodeII solution = new A117_PopulatingNextRightPointersInEachNodeII();
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

        //initialize a pointer to traverse each node on the same level by the order from left to right
        TreeLinkNode curParent = root;
        while (curParent != null) {
            //use dummy head to connect every start node of each level
            TreeLinkNode dummyHead = new TreeLinkNode(0);
            //use curChild to traverse the location of current pointer on the same level
            //(traverse linked list and connect them with each other on the same level)
            TreeLinkNode curChild = dummyHead;
            //if next level exists
            while (curParent != null) {
                //if current parent node has left child
                if (curParent.left != null) {
                    curChild.next = curParent.left;
                    curChild = curChild.next;
                }
                //if current parent node has right child
                if (curParent.right != null) {
                    curChild.next = curParent.right;
                    curChild = curChild.next;
                }
                //traverse to next node
                curParent = curParent.next;
            }
            //point curParent to the start node of next level if it exists
            curParent = dummyHead.next;
        }
    }
}
