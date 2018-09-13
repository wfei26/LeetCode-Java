import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A170_TwoSumIIIWithDataStructureDesign {
    private List<Integer> list = new ArrayList<>();
    private HashMap<Integer, Integer> map = new HashMap<>();

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (!map.containsKey(number)) {
            map.put(number, 1);
            list.add(number);
        }
        else {
            map.put(number, map.get(number) + 1);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int num1 = list.get(i);
            int num2 = value - num1;
            if ((num1 != num2 && map.containsKey(num2))
               ||(num1 == num2 && map.get(num1) > 1)) {
                return true;
            }
        }
        return false;
    }
}

