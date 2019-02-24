public class A277_FindTheCelebrity {
    public static void main(String[] args) {
        A277_FindTheCelebrity solution = new A277_FindTheCelebrity();
        int output = solution.findCelebrity(6);
        System.out.println(output);
    }

    /**
     * Two passes to solve the problem, kind of greedy thinking
     *
     * First pass: find the most possible candidate. Rule: if current candidate know any person, we will change to
     * another candidate since celebrity candidate CANNOT know anyone
     *
     * Second pass: check two conditions without any exception:
     * 1. candidate does not know anyone
     * 2. but everyone should know candidate
     * */
    public int findCelebrity(int n) {
        int candidate = 0;
        //first pass: find most possible candidate
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // second pass: check two valid conditions, violate any one of them will return false
        for (int i = 0; i < n; i++) {
            if (i != candidate && knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }
        return candidate;
    }

    public boolean knows(int a, int b) {
        if (b == 5) {
            return true;
        }
        if (a != 5) {
            return true;
        }
        return false;
    }
}
