public class A825_FriendsOfAppropriateAges {
    public static void main(String[] args) {
        A825_FriendsOfAppropriateAges solution = new A825_FriendsOfAppropriateAges();
        int[] input = {20,30,100,110,120};
        int output = solution.numFriendRequests(input);
        System.out.println(output);
    }

    /**
     * condition 1: B > 0.5 * A + 7
     * condition 2: B <= A
     * condition 3: useless if we have condition 2
     * So combine condition 1 and condition 2, we can have the range of B is (0.5*A+7, A]
     *
     * Then we could count number of people on every age, and calculate preSum of age array in order to easily get
     * number of people in a range of ages
     * */
    public int numFriendRequests(int[] ages) {
        int[] numOfPeople = new int[121];
        int[] totalPeople = new int[121];

        for (int i = 0; i < ages.length; i++) {
            numOfPeople[ages[i]]++;
        }

        for (int i = 1; i < 121; i++) {
            totalPeople[i] = totalPeople[i - 1] + numOfPeople[i];
        }

        int result = 0;
        // in every iteration, numOfPeople[i] represents number of people A
        for (int i = 15; i < 121; i++) {
            if (numOfPeople[i] == 0) {
                continue;
            }
            int count = totalPeople[i] - totalPeople[i/2 + 7];
            // since A cannot friend request to itself, we need to subtract them
            result += count * numOfPeople[i] - numOfPeople[i];
        }
        return result;
    }
}
