public class A369_PlusOneLinkedList {
    public static void main(String[] args) {
        A369_PlusOneLinkedList solution = new A369_PlusOneLinkedList();
        int[] myInputs = {1,2,3,9,6};
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
        ListNode prevPtr = dummy;
        ListNode curPtr = dummy;

        while (curPtr.next != null) {
            curPtr = curPtr.next;
            if (curPtr.val != 9) {
                prevPtr = curPtr;
            }
        }

        if (curPtr.val != 9) {
            curPtr.val++;
        }
        else {
            prevPtr.val++;
            prevPtr = prevPtr.next;
            while (prevPtr != null) {
                prevPtr.val = 0;
                prevPtr = prevPtr.next;
            }
        }

        if (dummy.val == 0) {
            return dummy.next;
        }
        else {
            return dummy;
        }
    }
}
