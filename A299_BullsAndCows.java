import java.util.HashMap;

public class A299_BullsAndCows {
    public static void main(String[] args) {
        A299_BullsAndCows solution = new A299_BullsAndCows();
        String secret = "1123";
        String guess = "0111";
        String output = solution.getHint(secret, guess);
        System.out.println(output);
    }

    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] secretMap = new int[10];
        int[] guessMap = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            //if two character are same with same position as well
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
            //otherwise, add freq of both maps by 1
            else {
                secretMap[secret.charAt(i) - '0']++;
                guessMap[guess.charAt(i) - '0']++;
            }
        }

        //count the rest of unmatched element
        //always add min frequency between two maps in each position
        for (int i = 0; i < secretMap.length; i++) {
            cows += Math.min(secretMap[i], guessMap[i]);
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}
