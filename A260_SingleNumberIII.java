public class A260_SingleNumberIII {
    public static void main(String[] args) {
        A260_SingleNumberIII solution = new A260_SingleNumberIII();
        int[] input = {1,2,1,3,2,5};
        int[] output = solution.singleNumber(input);
        System.out.println(output[0] + " " + output[1]);
    }

    /**
     * High level: find XOR combo of two result. Then find one of them
     *
     * Step 1: XOR all numbers, the result will be res1 ^ res2
     * Step 2: traverse all 32 bit indexes of previous XOR result, once we find there exist 1 on a bit index, break
     * the loop. Because one of the result at least have bit 1 on current bit index
     * Step 3: traverse all numbers in the input array, if we find a number & the bit index we found at step 2 is not 0,
     * then we can use res1 XOR current num to iteratively fill out effective bit in res1
     * (i.e. res1 ^ n1 ^ n1 ^ n2 ^ n2 = res1, if res1, n1 and n2 have bit 1 on the bitIndex
     * Step 4: find another result number by using res1 ^ allNumberXOR (i.e. res1 ^ (res1 ^ res2 ^ ...)) = res2)
     * */
    public int[] singleNumber(int[] nums) {
        int res1 = 0;
        int res2 = 0;

        // step 1: find XOR combo of two numbers
        int allNumXOR = 0;
        for (int num : nums) {
            allNumXOR ^= num;
        }

        // step 2: find effective bit index of a number in one of two result numbers
        int bitIndex;
        for (bitIndex = 0; bitIndex < 32; bitIndex++) {
            if ((allNumXOR & (1 << bitIndex)) != 0) {
                break;
            }
        }

        // step 3: find first result
        for (int num : nums) {
            if ((num & (1 << bitIndex)) != 0) {
                // WARNING: we MUST use "^=" at here, but not "=". Because there may have many numbers have bit 1 at
                // current bitIndex, we only want that single one, and cancel all the rest of numbers by using XOR
                res1 ^= num;
            }
        }

        // step 4: find second result
        res2 = res1 ^ allNumXOR;
        return new int[]{res1, res2};
    }
}
