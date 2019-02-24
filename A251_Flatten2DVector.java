import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class A251_Flatten2DVector {
    public static void main(String[] args) {
        int[][] input = {{1,2}, {3}, {4}};
        A251_Flatten2DVector solution = new A251_Flatten2DVector(input);
        System.out.println(solution.next());
        System.out.println(solution.next());
        solution.hasNext();
        System.out.println(solution.next());
        solution.hasNext();
    }

    /** solution 1: O(n) time + O(1) space */
    Iterator<List<Integer>> itr1;
    Iterator<Integer> itr2;
    public A251_Flatten2DVector(int[][] v) {
        List<List<Integer>> tempList = new ArrayList<>();
        for (int[] vector : v) {
            List<Integer> curList = new ArrayList<>();
            for (int num : vector) {
                curList.add(num);
            }
            tempList.add(curList);
        }
        itr1 = tempList.iterator();
    }

    public int next() {
        hasNext();
        return itr2.next();
    }

    /** if current inner iterator does not have more numbers, re-initialize next inner array as new iterator to
     * inner iterator variable */
    public boolean hasNext() {
        // WARNING: 1. DO NOT FORGET to check whether itr2 is null firstly; 2. MUST USE "while" instead of "if"
        while ((itr2 == null || !itr2.hasNext()) && itr1.hasNext()) {
            itr2 = itr1.next().iterator();
        }
        return itr2 != null && itr2.hasNext();
    }

    /** solution 2: O(n) time + O(n) space */
//    int curIndex;
//    int size;
//    List<Integer> numList;
//    int[] newVector;
//    public A251_Flatten2DVector(int[][] v) {
//        curIndex = 0;
//        numList = new ArrayList<>();
//        for (int[] vector : v) {
//            for (int num : vector) {
//                numList.add(num);
//                size++;
//            }
//        }
//
//        newVector = new int[size];
//        for (int i = 0; i < size; i++) {
//            newVector[i] = numList.get(i);
//        }
//    }
//
//    public int next2() {
//        int curNum = newVector[curIndex++];
//        return curNum;
//    }
//
//    public boolean hasNext2() {
//        return curIndex != size;
//    }
}
