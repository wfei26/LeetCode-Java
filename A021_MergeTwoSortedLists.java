public class A021_MergeTwoSortedLists {
    public static void main(String[] args) {
        A021_MergeTwoSortedLists solution = new A021_MergeTwoSortedLists();
        int[] input1 = {1,3,5};
        int[] input2 = {2,4,6};
        ListNode myList1 = solution.createList(input1);
        ListNode myList2 = solution.createList(input2);
        ListNode mergedList = solution.mergeTwoLists(myList1, myList2);
        solution.printList(mergedList);
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
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
}
