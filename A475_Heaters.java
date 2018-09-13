import java.lang.reflect.Array;
import java.util.Arrays;

public class A475_Heaters {
    public static void main(String[] args) {
        A475_Heaters solution = new A475_Heaters();
        int[] myHouses = {1,2,3,4};
        int[] myHeaters = {1,4};
        int myResult = solution.findRadius(myHouses, myHeaters);
        System.out.println(myResult);
    }

    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0 || heaters == null || heaters.length == 0) {
            return -1;
        }

        int result = Integer.MIN_VALUE;
        Arrays.sort(heaters);

        for (int house : houses) {
            //Find the correct position for the current house in the sorted heater array
            //Arrays.binarySearch will return the positive index if there is an equal number
            //exists in the heater array, or return the negative index, which is -(index) - 1
            //if there does not exist an equal number in the heater array
            int bsIndex = Arrays.binarySearch(heaters, house);
            if (bsIndex < 0) {
                bsIndex = - (bsIndex + 1);
            }
            int leftDistance = 0;
            int rightDistance = 0;
            //Ensure there exists a heater on the left side of current house
            if (bsIndex >= 1) {
                leftDistance = house - heaters[bsIndex - 1];
            }
            else {
                leftDistance = Integer.MAX_VALUE;
            }
            //Ensure there exists a heater on the right side of current house
            if (bsIndex < heaters.length) {
                rightDistance = heaters[bsIndex] - house;
            }
            else {
                rightDistance = Integer.MAX_VALUE;
            }
            //result should be max value of all minimum distance since the max distance
            //is able to cover all houses
            result = Math.max(result, Math.min(leftDistance, rightDistance));
        }
        return result;
    }
}
