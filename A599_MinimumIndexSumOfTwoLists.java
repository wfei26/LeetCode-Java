import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A599_MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        A599_MinimumIndexSumOfTwoLists solution = new A599_MinimumIndexSumOfTwoLists();
        String[] input1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] input2 = {"KFC", "Shogun", "Burger King"};
        String[] output = solution.findRestaurant(input1, input2);
        for (String str : output) {
            System.out.println(str);
        }
    }

    /** use a map to store index of each restaurant in list1, and then traverse the second list to
     * find all restaurant with minimum index sum */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int minIndexSum = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                if (i + j <= minIndexSum) {
                    // if we found smaller index sum, clear all list and update min sum value
                    if (i + j < minIndexSum) {
                        result.clear();
                        minIndexSum = i + j;
                    }
                    result.add(list2[i]);
                }
            }
        }
        // API: convert list to array: list.toArray(new String[])
        return result.toArray(new String[result.size()]);
    }
}
