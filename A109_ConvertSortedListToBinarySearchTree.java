public class A109_ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        A109_ConvertSortedListToBinarySearchTree solution = new A109_ConvertSortedListToBinarySearchTree();
        int[] myInputs = {-10,-3,0,5,9};
        ListNode myList = solution.createList(myInputs);
        TreeNode myResult = solution.sortedListToBST(myList);
        solution.printTree(myResult);
    }

    public ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curPtr = dummy;
        for (int i = 0; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            curPtr.next = newNode;
            curPtr = curPtr.next;
        }
        return dummy.next;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        TreeNode newTree = helper(head, null);
        return newTree;
    }

    public TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != tail && fastPtr.next != tail) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        TreeNode treeRoot = new TreeNode(slowPtr.val);
        treeRoot.left = helper(head, slowPtr);
        treeRoot.right = helper(slowPtr.next, tail);
        return treeRoot;
    }

    public void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.println(node.val);
        printTree(node.right);
    }
}
