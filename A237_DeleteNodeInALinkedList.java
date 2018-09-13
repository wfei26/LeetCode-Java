public class A237_DeleteNodeInALinkedList {
    public static void main(String[] args) {
        A237_DeleteNodeInALinkedList solution = new A237_DeleteNodeInALinkedList();
        int[] myInputs = {4, 5, 1, 9};
        ListNode myList = solution.createList(myInputs);
        ListNode deleteNode = myList.next;
        solution.deleteNode(deleteNode);
        while (myList != null) {
            System.out.println(myList.val);
            myList = myList.next;
        }
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

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
