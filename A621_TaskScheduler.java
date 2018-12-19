import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;

public class A621_TaskScheduler {
    public static void main(String[] args) {
        A621_TaskScheduler solution = new A621_TaskScheduler();
        char[] input = {'A', 'A', 'A', 'B', 'B', 'B'};
        int output = solution.leastInterval(input, 2);
        System.out.println(output);
    }

    public int leastInterval(char[] tasks, int n) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        for (int freq : map) {
            pq.offer(freq);
        }

        // get the character that has max frequency
        int maxFreq = pq.poll();
        // get count number of characters which have same highest frequency
        int countSameFreq = 1;
        while (!pq.isEmpty()) {
            if (pq.poll() == maxFreq) {
                countSameFreq++;
            }
            else {
                break;
            }
        }

        /* it is kind of greedy algorithm. we can separate all characters into (maxFreq - 1) of groups
         * when we have the character with highest frequency, each group will have n + 1 elements, because
         * each group must contain one top frequency element + n spaces of gap
         * eg: for the input         A A A A A B B B B B C C   and n = 2
         * the distribution will be  (A B C) (A B C) (A B X) (A B X) A B
         * But there is a special case, if there are more than one element which have same highest frequency
         * then we need to put them in last group, so we need to plus number count of elements that have
         * same highest frequency
         */
        result += (n + 1) * (maxFreq - 1) + countSameFreq;

        // corner case: if result is less than original array length, we need to return the max of them
        // eg: A B C   A B C   A B D   A | F D G   F
        // A is highest frequency, so we start with A based on greedy. However, we still have some character
        // left after arranging all A's
        return Math.max(result, tasks.length);
    }
}
