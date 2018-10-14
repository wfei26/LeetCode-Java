public class A434_NumberOfSegmentsInAString {
    public static void main(String[] args) {
        A434_NumberOfSegmentsInAString counter = new A434_NumberOfSegmentsInAString();
        String input = "";
        int output = counter.countSegments(input);
        System.out.println(output);
    }

    public int countSegments(String s) {
        int count = 0;
        for (String str : s.split(" ")) {
            //do not forget to check extra "" after splitting
            if (!str.equals("")) {
                count++;
            }
        }
        return count;
    }
}
