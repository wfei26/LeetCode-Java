import java.util.*;

public class A582_KillProcess {
    public static void main(String[] args) {
        A582_KillProcess solution = new A582_KillProcess();

        List<Integer> pid = new ArrayList<>();
        pid.add(1);
        pid.add(2);
        pid.add(3);
        List<Integer> ppid = new ArrayList<>();
        ppid.add(0);
        ppid.add(1);
        ppid.add(2);

        List<Integer> output = solution.killProcess(pid, ppid, 1);
        for (int num : output) {
            System.out.println(num);
        }
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // build a mapping with ppid -> children
        for (int i = 0; i < ppid.size(); i++) {
            int key = ppid.get(i);
            map.putIfAbsent(key, new ArrayList<>());
            List<Integer> list = map.get(key);
            list.add(pid.get(i));
            map.put(key, list);
        }

        List<Integer> killList = new ArrayList<>();
        // recursively find all children of killed pid
        dfs(killList, map, kill);
        return killList;
    }

    public void dfs(List<Integer> result, Map<Integer, List<Integer>> map, int pid) {
        result.add(pid);

        List<Integer> children = map.get(pid);
        if (children != null) {
            for (int child : children) {
                dfs(result, map, child);
            }
        }
    }
}
