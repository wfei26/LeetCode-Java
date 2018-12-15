import java.util.ArrayList;
import java.util.List;

public class A089_GrayCode {
    public static void main(String[] args) {
        A089_GrayCode solution = new A089_GrayCode();
        List<Integer> output = solution.grayCode(3);
        for (int num : output) {
            System.out.println(num);
        }
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if (n == 0) {
            return result;
        }

        // generate the sequence iteratively.
        // For example, when n=3, we can get the result based on n=2.
        // 00,01,11,10 -> (000,001,011,010 ) (110,111,101,100).
        for(int i = 0; i < n; i++) {
            int size = result.size();
            /* we need to get match starting number of every different length of digit to do OR operation
             * with all previous results
             * eg: previous result: 000
             *                      001
             *                      010
             *                      011
             * new added results:
             *          100 | 011 = 111
             *          100 | 010 = 110
             *          100 | 001 = 101
             *          100 | 000 = 100
             * but we need to match from last element of previous result, since we can follow the rule "successive"
            */
            for(int k = size - 1; k >= 0; k--) {
                result.add(result.get(k) | 1 << i);
            }
        }
        return result;
    }
}
