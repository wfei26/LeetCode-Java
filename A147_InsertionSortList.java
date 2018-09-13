public class A147_InsertionSortList {
    public static void main(String[] args) {
        A147_InsertionSortList solution = new A147_InsertionSortList();
        int[] myInputs = {4,2,1,3};
        ListNode myList = solution.createList(myInputs);
        ListNode sortedList = solution.insertionSortList(myList);
        solution.printList(sortedList);
    }

    public ListNode createList(int[] arr) {
        if (arr.length == 0) {
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

    public void printList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode curPtr = head;
        while (curPtr != null) {
            System.out.println(curPtr.val);
            curPtr = curPtr.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevPtr = dummy;
        ListNode curPtr = head;

        while (curPtr != null) {
            if (curPtr.next != null && curPtr.next.val < curPtr.val) {
                while (prevPtr.next != null && prevPtr.next.val < curPtr.next.val) {
                    prevPtr = prevPtr.next;
                }
                ListNode tempPtr = prevPtr.next;
                prevPtr.next = curPtr.next;
                curPtr.next = curPtr.next.next;
                prevPtr.next.next = tempPtr;
                prevPtr = dummy;
            }
            else {
                curPtr = curPtr.next;
            }
        }
        return dummy.next;
    }
}
