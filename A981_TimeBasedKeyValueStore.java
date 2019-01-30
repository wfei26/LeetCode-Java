import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class A981_TimeBasedKeyValueStore {
    public static void main(String[] args) {
        A981_TimeBasedKeyValueStore solution = new A981_TimeBasedKeyValueStore();

    }

    /**
     * use a hashmap with a treemap to build the data structure
     * since we want to search the key firstly in hash map, and then use binary search to search the
     * greatest timestamp less than or equal to the given timestamp in treemap
     * */
    Map<String, TreeMap<Integer, String>> map;

    /** Initialize your data structure here. */
    public A981_TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) {
            return "";
        }

        // API: treeMap.floorKey will return the greatest key less than or equal to the given key,
        // or null if there is no such key
        Integer floorKey = treeMap.floorKey(timestamp);
        if (floorKey == null) {
            return "";
        }
        return treeMap.get(floorKey);
    }
}
