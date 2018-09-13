public class A082_RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        A082_RemoveDuplicatesFromSortedListII solution = new A082_RemoveDuplicatesFromSortedListII();
        int[] myInputs = {1,2,3,3,4,4,5};
        ListNode myList = solution.createList(myInputs);
        ListNode newList = solution.deleteDuplicates(myList);
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevPtr = dummy;
        ListNode curPtr = prevPtr.next;
        boolean find = false;
        while (curPtr != null) {
            while (curPtr.next != null && curPtr.val == curPtr.next.val) {
                    curPtr = curPtr.next;
                    find = true;
            }
            if (find) {
                prevPtr.next = curPtr.next;
                find = false;
            }
            else {
                prevPtr = curPtr;
            }
            curPtr = curPtr.next;
        }
        return dummy.next;
    }
}
