public class A369_PlusOneLinkedList {
    public static void main(String[] args) {
        A369_PlusOneLinkedList solution = new A369_PlusOneLinkedList();
        int[] myInputs = {1,2,3,9,9};
        ListNode myList = solution.createList(myInputs);
        ListNode newList = solution.plusOne(myList);
        while (newList != null) {
            System.out.println(newList.val);
            newList = newList.next;
        }
    }

    public ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curPtr = dummy;
        for (int i = 0; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            curPtr.next = newNode;
            curPtr = curPtr.next;
        }
        return dummy.next;
    }

    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevNode = dummy;
        ListNode curNode = dummy;

        // start from the first node, set prevNode to the first node from the right that does not equal to 9
        // set curNode to last node of the linked list
        while (curNode.next != null) {
            curNode = curNode.next;
            if (curNode.val != 9) {
                prevNode = curNode;
            }
        }

        // if last node is not 9, plus 1 directly
        if (curNode.val != 9) {
            curNode.val++;
        }
        // if last node is 9, replace all 9 to 0 after prevNode, and plus 1 on the prevNode
        else {
            prevNode.val++;
            prevNode = prevNode.next;
            while (prevNode != null) {
                prevNode.val = 0;
                prevNode = prevNode.next;
            }
        }

        // check whether the number is combined with all 9's, eg: 99999 -> 100000
        if (dummy.val == 0) {
            return dummy.next;
        }
        else {
            return dummy;
        }
    }
}
