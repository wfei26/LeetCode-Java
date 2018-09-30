public class A681_NextClosestTime {
    public static void main(String[] args) {
        A681_NextClosestTime solution = new A681_NextClosestTime();
        String input = "00:00";
        String output = solution.nextClosestTime(input);
        System.out.println(output);
    }

    public String nextClosestTime(String time) {
        if (time == null || time.length() == 0) {
            return time;
        }

        //initialize an int array as dividers to divide total minutes to correct time format
        int[] timeDivider = {600, 60, 10, 1};
        //initialize an char array to store correct format of new generated time in every iteration
        char[] newTime = new char[4];
        //Transfer current time to minutes
        int curTime = Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3));

        //WARNING: i starts from 1 to 1440, NOT from 0 to 1439
        for (int i = 1, j = 0; i <= 1440; i++) {
            int timeRemain = (curTime + i) % 1440;

            //inner loop will convert minutes to correct time format and check if it is valid
            for (j = 0; j < 4; j++) {
                //WARNING: do not forget to convert value to char type
                newTime[j] = (char)('0' + timeRemain / timeDivider[j]);
                //update minutes remaining
                timeRemain %= timeDivider[j];

                //if time array does not contain current number, break the current loop
                //IMPORTANT: String.indexOf() will return -1 if string does not contain a character
                if (time.indexOf(newTime[j]) == -1) {
                    break;
                }
            }

            //if the inner loop does not break after executing four times
            //it means we found the minimum results, break the loop
            if (j == 4) {
                break;
            }
        }
        //IMPORTANT: remember the API that how to create a new String by using char array
        //new String(char[] arr, int startIndex, int length)
        String result = new String(newTime, 0, 2) + ':' + new String(newTime, 2, 2);
        return result;
    }
}
