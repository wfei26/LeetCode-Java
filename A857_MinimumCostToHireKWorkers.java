import java.util.PriorityQueue;

public class A857_MinimumCostToHireKWorkers {
    public static void main(String[] args) {
        A857_MinimumCostToHireKWorkers solution = new A857_MinimumCostToHireKWorkers();
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        double output = solution.mincostToHireWorkers(quality, wage, 2);
        System.out.println(output);
    }

    /*
    * 1. Every worker in the paid group should be paid in the ratio of their quality compared to other workers
    * in the paid group.
    * So for any two workers in the paid group,
    * we have    wage[i] : wage[j] = quality[i] : quality[j]
    * So we have wage[i] : quality[i] = wage[j] : quality[j]
    * We pay wage to every worker in the group with the same ratio compared to his own quality.

    * 2. Every worker in the paid group must be paid at least their minimum wage expectation."
    * For every worker, he has an expected ratio of wage compared to his quality.

    * So to minimize the total wage, we want a small ratio.
    * So we sort all workers with their expected ratio, and pick up K first worker.
    * Now we have a minimum possible ratio for K worker and we their total quality.
    * */
    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        if (q.length == 0 || w.length == 0 || K == 0 || q.length != w.length) {
            return 0;
        }

        // sort the workers by their ratio (wage / quality)
        // REMEMBER: when we want to sort Double numbers in priority queue,
        // we need to use Double.compare(a, b)
        PriorityQueue<WorkerInfo> workers = new PriorityQueue<>(
                (a, b) -> (Double.compare(a.ratio, b.ratio))
        );
        for (int i = 0; i < q.length; i++) {
            WorkerInfo newWorker = new WorkerInfo(w[i], q[i]);
            workers.offer(newWorker);
        }

        Double result = Double.MAX_VALUE;
        int curQualitySum = 0;
        PriorityQueue<WorkerInfo> finalWorkers = new PriorityQueue<>(
                (a, b) -> (b.quality - a.quality)
        );

        // our target is to find the minimum payment amount with K people based on every different standard ratio
        // so we iteratively calculate minimum result of (wage/quality) * total quality
        // the idea is equivalent to personal hourly wage * total working hours
        // and the rest of workers should follow this standard
        while (!workers.isEmpty()) {
            WorkerInfo curWorker = workers.poll();
            curQualitySum += curWorker.quality;
            finalWorkers.offer(curWorker);

            // if size of pq is over than k, we need to subtract the current quality sum by max quality value
            // since we always want to choose k people with k smallest quality value
            if (finalWorkers.size() > K) {
                curQualitySum -= finalWorkers.poll().quality;
            }
            // update minimum total wage at the end of every iteration
            if (finalWorkers.size() == K) {
                result = Math.min(result, curQualitySum * curWorker.ratio);
            }
        }
        return result;
    }
}

class WorkerInfo {
    double ratio;
    int quality;

    public WorkerInfo(int wage, int quality) {
        this.ratio = (double)wage / quality;
        this.quality = quality;
    }
}
