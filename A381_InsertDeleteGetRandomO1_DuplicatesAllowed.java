import java.util.*;

public class A381_InsertDeleteGetRandomO1_DuplicatesAllowed {
    public static void main(String[] args) {
        A381_InsertDeleteGetRandomO1_DuplicatesAllowed solution = new A381_InsertDeleteGetRandomO1_DuplicatesAllowed();
    }

    Map<Integer, Set<Integer>> map;
    List<Integer> nums;
    Random rand;
    /** Initialize your data structure here. */
    public A381_InsertDeleteGetRandomO1_DuplicatesAllowed() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
            map.get(val).add(nums.size() - 1);
            return true;
        }
        else {
            map.get(val).add(nums.size() - 1);
            return false;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // if removing number is not at the last index of array list, we need to swap the last number with the removing number
        if (!map.get(val).contains(nums.size() - 1)) {
            int curPosIndex = map.get(val).iterator().next();
            int lastPosVal = nums.get(nums.size() - 1);

            // reset index of last number
            map.get(lastPosVal).remove(nums.size() - 1);
            map.get(lastPosVal).add(curPosIndex);

            // reset index of removing number
            map.get(val).remove(curPosIndex);
            map.get(val).add(nums.size() - 1);

            // WARNING: DO NOT FORGET to move last element to current removing index
            nums.set(curPosIndex, lastPosVal);
        }

        // after swapping (may be not necessary), remove last number from both of map and array list
        map.get(val).remove(nums.size() - 1);
        if (map.get(val).size() == 0) {
            map.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
