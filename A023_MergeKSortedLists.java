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
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode list : lists) {
            // WARNING: DO NOT FORGET to check null condition before adding to PQ!
            if (list != null) {
                heap.offer(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curNode = dummy;
        while (!heap.isEmpty()) {
            ListNode curMinNode = heap.poll();
            if (curMinNode.next != null) {
                heap.offer(curMinNode.next);
            }
            // append curMinNode to the result list
            curNode.next = curMinNode;
            curNode = curNode.next;
        }
        return dummy.next;
    }
}
