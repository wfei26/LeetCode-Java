public class A141_LinkedListCycle {
    public static void main(String[] args) {
        A141_LinkedListCycle solution = new A141_LinkedListCycle();
        int[] myInputs = {1,2,3,4,5};
        ListNode myList = solution.createList(myInputs);
        boolean output = solution.hasCycle(myList);
        System.out.println(output);
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

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
