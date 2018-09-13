public class A083_RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        A083_RemoveDuplicatesFromSortedList solution = new A083_RemoveDuplicatesFromSortedList();
        int[] myInputs = {1,2,2,3,4,5,6,6,6,7,8,8,8,8,8,9,10,10};
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

        ListNode prevPtr = head;
        ListNode curPtr = prevPtr.next;
        while (curPtr != null) {
            if (prevPtr.val == curPtr.val) {
                prevPtr.next = curPtr.next;
            }
            else {
                prevPtr = curPtr;
            }
            curPtr = curPtr.next;
        }
        return head;
    }
}
