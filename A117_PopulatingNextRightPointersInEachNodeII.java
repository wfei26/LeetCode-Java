public class A117_PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {
        A117_PopulatingNextRightPointersInEachNodeII solution = new A117_PopulatingNextRightPointersInEachNodeII();
        int[] myInputs = {1,2,3,4,5,6,7};
        Node myTree = solution.sortedArrayToBST(myInputs);
        solution.connect(myTree);
    }

    public Node sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
        }
        Node newTree = helpers(nums, 0, nums.length - 1);
        return newTree;
    }

    public Node helpers(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        Node newNode = new Node(num[mid]);
        newNode.left = helpers(num, low, mid - 1);
        newNode.right = helpers(num, mid + 1, high);
        return newNode;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node parent = root;
        while (parent != null) {
            // curParent trace parent node on parent level
            Node curParent = parent;
            Node dummy = new Node(-1);
            // curNode trace child node on child level
            Node curNode = dummy;
            while (curParent != null) {
                if (curParent.left != null) {
                    curNode.next = curParent.left;
                    curNode = curNode.next;
                }
                if (curParent.right != null) {
                    curNode.next = curParent.right;
                    curNode = curNode.next;
                }
                curParent = curParent.next;
            }
            // WARNING: DO NOT FORGET to set dummy.next = null
            parent = dummy.next;
            dummy.next = null;
        }
        return root;
    }

    class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node(int x) {val = x;}
    }
}
