import java.util.Comparator;
import java.util.PriorityQueue;

public class A023_MergeKSortedLists {
    public static void main(String[] args) {
        A023_MergeKSortedLists solution = new A023_MergeKSortedLists();
        int[] myArr1 = {1, 4, 5};
        int[] myArr2 = {1, 3, 4};
        int[] myArr3 = {2, 6};
        ListNode myList1 = solution.createList(myArr1);
        ListNode myList2 = solution.createList(myArr2);
        ListNode myList3 = solution.createList(myArr3);

        ListNode[] myInputLists = new ListNode[3];
        myInputLists[0] = myList1;
        myInputLists[1] = myList2;
        myInputLists[2] = myList3;

        ListNode myResultList = solution.mergeKLists(myInputLists);
        while (myResultList != null) {
            System.out.print(myResultList.val + " ");
            myResultList = myResultList.next;
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        //use a PQ to find min head of every list
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, new myComparator());
        for (int i = 0; i < lists.length; i++) {
            //DO NOT FORGET to check null condition before adding to PQ!
            if (lists[i] != null) {
                heap.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curNode = dummy;
        while (!heap.isEmpty()) {
            //get the min node from PQ, and then add next node from the list
            //with popped head into the PQ ---> O(lgn)
            ListNode curMinNode = heap.poll();
            if (curMinNode.next != null) {
                heap.offer(curMinNode.next);
            }
            //connect popped min node to the result linked list
            curNode.next = curMinNode;
            curNode = curNode.next;
        }
        return dummy.next;
    }

    //since ListNode is not primitive type, we need to create a comparator
    //class with ListNode type for PQ
    public class myComparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }
}
