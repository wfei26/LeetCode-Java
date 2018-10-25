import java.util.HashSet;

public class A379_DesignPhoneDirectory {
    public static void main(String[] args) {

    }

    HashSet<Integer> phoneDict = new HashSet<>();
    int curPhone = 0;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public A379_DesignPhoneDirectory(int maxNumbers) {
        for (int i = 0; i < maxNumbers; i++) {
            phoneDict.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        int phoneVal = curPhone;
        phoneDict.remove(phoneVal);
        curPhone++;
        return phoneVal;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        
    }

    /** Recycle or release a number. */
    public void release(int number) {

    }
}
