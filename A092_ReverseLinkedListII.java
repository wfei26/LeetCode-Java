public class A092_ReverseLinkedListII {
    public static void main(String[] args) {
        A092_ReverseLinkedListII solution = new A092_ReverseLinkedListII();
        int[] myInputs = {1,2,3,4,5,6,7};
        ListNode myList = solution.createList(myInputs);
        ListNode resultList = solution.reverseBetween(myList, 1, 7);
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode leftTail = dummy;
        ListNode rightTail = head;
        for (int i = 1; i < m; i++) {
            leftTail = head;
            head = head.next;
            rightTail = head;
        }
        ListNode newHead = null;
        ListNode nextNode = null;
        for (int i = m; i <= n && head != null; i++) {
            nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        leftTail.next = newHead;
        rightTail.next = nextNode;
        return dummy.next;
    }
}
