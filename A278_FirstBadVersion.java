public class A278_FirstBadVersion {
    public static void main(String[] args) {
        A278_FirstBadVersion solution = new A278_FirstBadVersion();
        int output = solution.firstBadVersion(11);
        System.out.println(output);
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // if current item is a bad version, cut the right half
            // if current item is a good version, cut the left half
            // until left == right, return left or right
            if (!isBadVersion(mid)) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    public boolean isBadVersion(int version) {
        if (version >= 8) {
            return true;
        }
        else {
            return false;
        }
    }
}
