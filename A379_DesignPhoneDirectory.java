import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class A379_DesignPhoneDirectory {
    public static void main(String[] args) {
        A379_DesignPhoneDirectory directory = new A379_DesignPhoneDirectory(1);
        // It can return any available phone number. Here we assume it returns 0.
        directory.get();

        // Assume it returns 1.
        directory.get();

        // The number 2 is available, so return true.
        directory.check(2);

        // It returns 2, the only number that is left.
        //directory.get();

        // The number 2 is no longer available, so return false.
        directory.check(2);

        // Release number 2 back to the pool.
        directory.release(2);

        // Number 2 is available again, return true.
        directory.check(2);

        directory.get();
        directory.get();
    }

    //use hashset to control data unique, use queue to control data flow
    HashSet<Integer> phoneDict = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public A379_DesignPhoneDirectory(int maxNumbers) {
        for (int i = 0; i < maxNumbers; i++) {
            phoneDict.add(i);
            queue.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (!phoneDict.isEmpty()) {
            int numToDelete = queue.poll();
            phoneDict.remove(numToDelete);
            return numToDelete;
        }
        else{
            return -1;
        }
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return phoneDict.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        //MUST check if set contains input number, if so, then add this number to queue
        if (phoneDict.add(number)) {
            queue.offer(number);
        }
    }
}
