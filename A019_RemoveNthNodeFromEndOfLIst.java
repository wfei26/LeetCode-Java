public class A019_RemoveNthNodeFromEndOfLIst {
    public static void main(String[] args) {
        A019_RemoveNthNodeFromEndOfLIst solution = new A019_RemoveNthNodeFromEndOfLIst();
        int[] myInputs = {1,2,3,4,5};
        int removeIndex = 2;
        ListNode myList = solution.createList(myInputs);
        ListNode newList = solution.removeNthFromEnd(myList, removeIndex);
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slowPtr = dummy;
        ListNode fastPtr = dummy;

        for (int i = 0; i <= n; i++) {
            fastPtr = fastPtr.next;
        }

        while (fastPtr != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        slowPtr.next = slowPtr.next.next;
        return dummy.next;
    }
}
