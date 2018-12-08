import java.util.*;

public class A811_SubdomainVisitCount {
    public static void main(String[] args) {
        A811_SubdomainVisitCount solution = new A811_SubdomainVisitCount();
        String[] input = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> output = solution.subdomainVisits(input);
        for (String str : output) {
            System.out.println(str);
        }
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> results = new ArrayList<>();

        // use hash map to store domain-frequency pair for every domain and sub-domain
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            int frequency = Integer.valueOf(parts[0]);
            String curDomain = parts[1];

            // split by '.', to store frequency for every sub-domain as well as main domain
            map.put(curDomain, map.getOrDefault(curDomain, 0) + frequency);
            for (int i = 0; i < curDomain.length(); i++) {
                if (curDomain.charAt(i) == '.') {
                    String curKey = curDomain.substring(i + 1);
                    map.put(curKey, map.getOrDefault(curKey, 0) + frequency);
                }
            }
        }

        // retrieve domains and their frequencies from map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            results.add(entry.getValue() + " " + entry.getKey());
        }
        return results;
    }
}
