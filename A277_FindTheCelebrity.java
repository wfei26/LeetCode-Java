public class A277_FindTheCelebrity {
    public static void main(String[] args) {
        A277_FindTheCelebrity solution = new A277_FindTheCelebrity();
        int output = solution.findCelebrity(6);
        System.out.println(output);
    }

    public int findCelebrity(int n) {
        int candidate = 0;
        // first pass: find the most possible candidate
        // rule: if current candidate know any one person, we will change to another candidate
        // since candidate CANNOT know anyone
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // second pass: check two valid conditions:
        // candidate do not know anyone AND everyone knows candidate
        // violate any one of them will return false
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
