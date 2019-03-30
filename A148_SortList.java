public class A148_SortList {
    public static void main(String[] args) {
        A148_SortList solution = new A148_SortList();
        int[] myInputs = {-1,5,3,4,0,-3,9,5,6,2};
        ListNode myList = solution.createList(myInputs);
        ListNode newList = solution.sortList(myList);
        solution.printList(newList);
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

    /** use merge sort (divide and conquer) to sort list: use slow and fast pointer to find middle node, and then
     * recursively divide current two list into smaller parts */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fastPtr = head;
        ListNode slowPtr = head;
        ListNode prevPtr = null;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
        }
        // WARNING: DO NOT FORGET to set next pointer of middle pointer to null, otherwise, it may generate cyclic list
        prevPtr.next = null;

        // recursively divide list into two parts and conquer each part
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slowPtr);
        return merge(l1, l2);
    }

    /** merge two sorted list */
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return  l1;
        }

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else {
            l2.next = merge(l2.next, l1);
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
