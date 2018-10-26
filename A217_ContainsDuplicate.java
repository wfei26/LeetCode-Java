import java.util.HashSet;

public class A217_ContainsDuplicate {
    public static void main(String[] args) {
        A217_ContainsDuplicate checker = new A217_ContainsDuplicate();
        int[] inputs = {1,2,3,1,5};
        boolean output = checker.containsDuplicate(inputs);
        System.out.println(output);
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            else {
                set.add(num);
            }
        }
        return false;
    }
}
