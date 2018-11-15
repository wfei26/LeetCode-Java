import java.util.HashSet;

public class A929_UniqueEmailAddresses {
    public static void main(String[] args) {
        A929_UniqueEmailAddresses solution = new A929_UniqueEmailAddresses();
        String[] inputs = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int output = solution.numUniqueEmails(inputs);
        System.out.println(output);
    }

    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }

        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            //split email by "@", we only modify everything before "@"
            String[] emailSegment = email.split("@");
            //split front part by "+", we only need everything before "+"
            String[] plusSegment = emailSegment[0].split("\\+");
            set.add(plusSegment[0].replace(".", "") + emailSegment[1]);
        }
        return set.size();
    }
}
