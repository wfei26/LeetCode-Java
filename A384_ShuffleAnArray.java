import java.util.Random;

public class A384_ShuffleAnArray {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        A384_ShuffleAnArray solution = new A384_ShuffleAnArray(input);

        // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
        solution.shuffle();

        // Resets the array back to its original configuration [1,2,3].
        solution.reset();

        // Returns the random shuffling of array [1,2,3].
        solution.shuffle();
    }

    final int[] originalNums;
    int[] shuffleNums;
    int size;
    public A384_ShuffleAnArray(int[] nums) {
        originalNums = nums;
        // deep copy of original array
        shuffleNums = originalNums.clone();
        size = originalNums.length;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalNums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        // every iteration after shuffling a number, we will assure one position,
        // do it iteratively, all the way to the end
        for (int i = 0; i < size; i++) {
            // we shuffle an index from rest of position, and then swap with current position
            int randomIndex = i + rand.nextInt(size - i);
            swap(shuffleNums, i, randomIndex);
        }
        return shuffleNums;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
