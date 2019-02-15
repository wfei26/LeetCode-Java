import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A422_ValidWordSquare {
    public static void main(String[] args) {
        A422_ValidWordSquare solution = new A422_ValidWordSquare();
        List<String> input = new ArrayList<>(Arrays.asList(  "abcd", "bnrt", "crmy", "dtye"));
        boolean output = solution.validWordSquare(input);
        System.out.println(output);
    }

    /**
     * Use brute force to traverse all character in matrix, check if words[i][j] is equal to words[j][i]
     * we also need to check three boundary conditions
     * 1. if j is too long, return false directly
     * 2. if i is too long, return false directly
     * */
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                // WARNING: DO NOT FORGET to check boundary of i and j
                if (j >= words.size() || i >= words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
