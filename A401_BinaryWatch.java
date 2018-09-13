import java.util.ArrayList;
import java.util.List;

public class A401_BinaryWatch {
    public static void main(String[] args) {
        A401_BinaryWatch solution = new A401_BinaryWatch();
        int myInput = 1;
        List<String> myResults = solution.readBinaryWatch(myInput);
        for (int i = 0; i < myResults.size(); i++) {
            System.out.println(myResults.get(i));
        }
    }

    public List<String> readBinaryWatch(int num) {
        List<String> timeList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    timeList.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return timeList;
    }
}
