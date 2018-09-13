public class A206_ReverseLinkedList {
    public static void main(String[] args) {
        A206_ReverseLinkedList solution = new A206_ReverseLinkedList();
        int[] myInputs = {1,2,3,4,5};
        ListNode myList = solution.createList(myInputs);
        ListNode resultList = solution.reverseList(myList);
        while (resultList != null) {
            System.out.println(resultList.val);
            resultList = resultList.next;
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

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
}
