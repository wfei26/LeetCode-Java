public class A346_MovingAverageFromDataStream {
    private int[] window;
    private int len = 0, insertPos = 0;
    private double sum;

    public static void main(String[] args) {
        A346_MovingAverageFromDataStream solution = new A346_MovingAverageFromDataStream();
        solution.MovingAverage(3);
        double result1 = solution.next(1);
        System.out.println(result1);
        double result2 = solution.next(10);
        System.out.println(result2);
        double result3 = solution.next(3);
        System.out.println(result3);
        double result4 = solution.next(5);
        System.out.println(result4);
    }

    /** Initialize your data structure here. */
    public void MovingAverage(int size) {
        window = new int[size];
    }

    public double next(int val) {
        if (len < window.length) {
            len++;
        }
        sum -= window[insertPos];
        sum += val;
        window[insertPos] = val;
        insertPos++;
        insertPos %= window.length;
        return sum/len;
    }
}
