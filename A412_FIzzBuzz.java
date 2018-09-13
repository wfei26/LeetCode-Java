import java.util.ArrayList;
import java.util.List;

public class A412_FIzzBuzz {
    public static void main(String[] args) {
        A412_FIzzBuzz solution = new A412_FIzzBuzz();
        int myInput = 0;
        List<String> myResult = solution.fizzBuzz(myInput);
        for (int i = 0; i < myResult.size(); i++) {
            System.out.println(myResult.get(i));
        }
    }

    public List<String> fizzBuzz(int n) {
        List<String> myList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                myList.add("FizzBuzz");
            }
            else if (i % 3 == 0 && i % 5 != 0) {
                myList.add("Fizz");
            }
            else if (i % 3 != 0 && i % 5 == 0) {
                myList.add("Buzz");
            }
            else {
                myList.add(Integer.toString(i));
            }
        }
        return myList;
    }
}
