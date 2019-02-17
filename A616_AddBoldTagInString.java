import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A616_AddBoldTagInString {
    public static void main(String[] args) {
        A616_AddBoldTagInString solution = new A616_AddBoldTagInString();
        String s1 = "aaabbcc";
        String[] dict1 = {"aaa", "aab", "bc"};

        String output1 = solution.addBoldTag(s1, dict1);
        System.out.println(output1);

        String s2 = "abcxyz123";
        String[] dict2 = {"abc", "123"};

        String output2 = solution.addBoldTag(s2, dict2);
        System.out.println(output2);
    }

    /** the solution contain three phases: find bold words in string, merge intervals, and build new string
     * from merged intervals */
    public String addBoldTag(String s, String[] dict) {
        if (s.length() == 0 || dict.length == 0) {
            return s;
        }

        /** phase 1: create intervals by searching bold words in string */
        List<Interval> intervals = new ArrayList<>();
        for (String word : dict) {
            for (int i = 0; i <= s.length() - word.length(); i++) {
                if (s.substring(i).startsWith(word)) {
                    intervals.add(new Interval(i, i + word.length() - 1));
                }
            }
        }
        if (intervals.size() == 0) {
            return s;
        }
        // MUST SORT by starting time before merging intervals
        Collections.sort(intervals, (a, b) -> (a.start - b.start));


        /** phase 2: merge intervals */
        List<Interval> newIntervals = new ArrayList<>();
        int prevStart = intervals.get(0).start;
        int prevEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start - 1 <= prevEnd) {
                prevEnd = Math.max(prevEnd, intervals.get(i).end);
            }
            else {
                newIntervals.add(new Interval(prevStart, prevEnd));
                prevStart = intervals.get(i).start;
                prevEnd = intervals.get(i).end;
            }
        }
        // WARNING: DO NOT FORGET to add last interval
        newIntervals.add(new Interval(prevStart, prevEnd));

        /** phase 3: build new string with bold tags*/
        StringBuilder sb = new StringBuilder();
        prevStart = 0;

        for (Interval interval : newIntervals) {
            sb.append(s.substring(prevStart, interval.start));
            sb.append("<b>");
            sb.append(s.substring(interval.start, interval.end + 1));
            sb.append("</b>");
            prevStart = interval.end + 1;
        }
        // WARNING: DO NOT FORGET to append the rest of string if necessary
        if (prevStart < s.length()) {
            sb.append(s.substring(prevStart));
        }
        return sb.toString();
    }

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
