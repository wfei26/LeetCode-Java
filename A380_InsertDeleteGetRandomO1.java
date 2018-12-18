import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class A380_InsertDeleteGetRandomO1 {
    public static void main(String[] args) {
        A380_InsertDeleteGetRandomO1 randomSet = new A380_InsertDeleteGetRandomO1();
        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomSet.insert(1);

        // Returns false as 2 does not exist in the set.
        randomSet.remove(2);

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomSet.insert(2);

        // getRandom should return either 1 or 2 randomly.
        randomSet.getRandom();

        // Removes 1 from the set, returns true. Set now contains [2].
        randomSet.remove(1);

        // 2 was already in the set, so return false.
        randomSet.insert(2);

        // Since 2 is the only number in the set, getRandom always return 2.
        randomSet.getRandom();
    }

    Random rand;
    List<Integer> nums;
    HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public A380_InsertDeleteGetRandomO1() {
        rand = new Random();
        nums = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            //Little trick: use nums.size() (before adding) as position of input value
            map.put(val, nums.size());
            nums.add(val);
            return true;
        }
        else {
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        //get the current position of input value in arraylist by getting pos using map key
        int valPos = map.get(val);

        //get the value of last item in array list
        int lastItem = nums.get(nums.size() - 1);

        // swap last item to the position of input value (to overwrite the value we want to remove),
        // and then remove the last one
        nums.set(valPos, lastItem);
        // DO NOT FORGET to update position of last item in map, as well as remove the input value from map
        map.put(lastItem, valPos);

        nums.remove(nums.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        //select a random position from range of list size
        return nums.get(rand.nextInt(nums.size()));
    }
}
