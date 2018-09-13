public class A203_RemoveLinkedListElements {
    public static void main(String[] args) {
        A203_RemoveLinkedListElements solution = new A203_RemoveLinkedListElements();
        int[] myInputs = {1};
        ListNode myList = solution.createList(myInputs);
        int myVal = 1;
        ListNode newList = solution.removeElements(myList, myVal);
        while (newList != null) {
            System.out.println(myList.val);
            myList = myList.next;
        }
    }

    public ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode curPtr = dummy;
        for (int i = 0; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            curPtr.next = newNode;
            curPtr = curPtr.next;
        }
        return dummy.next;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevPtr = dummy;
        ListNode curPtr = head;
        while (curPtr != null) {
            if (curPtr.val == val) {
                prevPtr.next = curPtr.next;
            }
            else {
                prevPtr = curPtr;
            }
            curPtr = curPtr.next;
        }
        return dummy.next;
    }
}
