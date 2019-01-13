public class A362_DesignHitCounter {
    public static void main(String[] args) {
        A362_DesignHitCounter counter = new A362_DesignHitCounter();

        // hit at timestamp 1.
        counter.hit(1);

        // hit at timestamp 2.
        counter.hit(2);

        // hit at timestamp 3.
        counter.hit(3);

        // get hits at timestamp 4, should return 3.
        counter.getHits(4);

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 4.
        counter.getHits(300);

        // get hits at timestamp 301, should return 3.
        counter.getHits(301);
    }

    // times array stores lastest timestamp for each mod value from 1 - 300
    private int[] times;
    // hits array stores total number of hits value for each latest timestamp mod value
    private int[] hits;

    /** Initialize your data structure here. */
    public A362_DesignHitCounter() {
        times = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int timeIndex = timestamp % 300;
        // if timestamp is updated, eg: timestamp = 301, but we have times[1] before 301.
        if (times[timeIndex] != timestamp) {
            times[timeIndex] = timestamp;
            hits[timeIndex] = 1;
        }
        else {
            hits[timeIndex]++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int res = 0;
        // we only count all hits that in 300 seconds
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                res += hits[i];
            }
        }
        return res;
    }
}
