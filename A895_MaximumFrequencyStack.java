import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class A895_MaximumFrequencyStack {
    public static void main(String[] args) {
        A895_MaximumFrequencyStack solution = new A895_MaximumFrequencyStack();
    }

    /**
     * @param maxFreq: current max frequency value
     * @param stackMap: key -> frequency, value -> a stack stores all numbers with same frequency
     * @param freqMap: key -> number, value -> frequency of this number
     * */
    int maxFreq;
    Map<Integer, Stack<Integer>> stackMap;
    Map<Integer, Integer> freqMap;
    public A895_MaximumFrequencyStack() {
        maxFreq = 0;
        stackMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    /** store all numbers that have same frequency in one stack, whenever we have a new maxFreq, add another stack */
    public void push(int x) {
        freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        int curFreq = freqMap.get(x);
        maxFreq = Math.max(maxFreq, curFreq);

        stackMap.putIfAbsent(curFreq, new Stack<>());
        stackMap.get(curFreq).push(x);
    }

    /** pop the top item from max frequency stack */
    public int pop() {
        int popItem = stackMap.get(maxFreq).pop();
        if (stackMap.get(maxFreq).isEmpty()) {
            stackMap.remove(maxFreq);
            maxFreq--;
        }
        freqMap.put(popItem, freqMap.get(popItem) - 1);
        return popItem;
    }
}
