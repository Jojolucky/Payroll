package tiktokoa;

import java.util.*;

// GPU

public class OA202309N5 {
    public static void main(String[] args) {
//        List<Integer> cost = new ArrayList<>(Arrays.asList(2, 4, 6, 5));
//        List<Integer> com_1 = new ArrayList<>(Arrays.asList(1,1,1,0));
//        List<Integer> com_2 = new ArrayList<>(Arrays.asList(0,0,1,1));
//        int min = 2;
//        Solution1 s1 = new Solution1();
//        long res = s1.getMinCost(4, cost, com_1, com_2, min);
//        System.out.println(res);


        while (true) {
            int n = new Random().nextInt(100);
            int min_com = new Random().nextInt(n / 2 + 1) + 1;
            List<Integer> cost = generateCost(n);
            List<Integer> com_1 = generateCom(n);
            List<Integer> com_2 = generateCom(n);
            Solution1 sol1 = new Solution1();
            Solution2 sol2 = new Solution2();
            long start1 = System.currentTimeMillis();
            long s1 = sol1.getMinCost(n, cost, com_1, com_2, min_com);
            long end1 = System.currentTimeMillis();
            System.out.println("solution1: " + s1 + "   time_consumption: " + (end1 - start1) + "ms");
            long start2 = System.currentTimeMillis();
            long s2 = sol2.getMinCost(n, cost, com_1, com_2, min_com);
            long end2 = System.currentTimeMillis();
            System.out.println("solution2: " + s2 + "   time_consumption: " + (end2 - start2) + "ms");
            System.out.println("sol 1 is faster: " + ((end1 - start1) < (end2 - start2)));
            if (s1 != s2) {
                break;
            }
        }
    }
    public static class Solution1 {
        public long getMinCost(int n, List<Integer> cost, List<Integer> com_1, List<Integer> com_2, int min_com) {
            List<List<Integer>> cpus = new ArrayList<>();
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < n; i++) {
                cpus.add(Arrays.asList(cost.get(i), com_1.get(i), com_2.get(i)));
                sum1 += com_1.get(i);
                sum2 += com_2.get(i);
            }
            if (sum1 < min_com || sum2 < min_com) {
                return -1;
            }
            Collections.sort(cpus, (a, b) -> a.get(0) - b.get(0));
            PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> b - a);
            PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);
            for (int i = 0; i < min_com; i++) {
                pq1.add(Integer.MAX_VALUE);
                pq2.add(Integer.MAX_VALUE);
            }
            long res = 0;
            for (int i = 0; i < n; i++) {
                int cur_cost = cpus.get(i).get(0);
                int work1 = cpus.get(i).get(1);
                int work2 = cpus.get(i).get(2);
                if (work1 > 0 && work2 > 0) {
                    long total_cost = (long) pq1.peek() + (long) pq2.peek();
                    if (cur_cost < total_cost) {
                        res += cur_cost;
                        pq1.add(0);
                        pq2.add(0);
                        pq1.poll();
                        pq2.poll();
                    } else {
                        break;
                    }
                } else if (work1 > 0) {
                    int cur_1 = pq1.peek();
                    if (cur_cost < cur_1) {
                        pq1.add(cur_cost);
                        pq1.poll();
                    }
                } else if (work2 > 0) {
                    int cur_2 = pq2.peek();
                    if (cur_cost < cur_2) {
                        pq2.add(cur_cost);
                        pq2.poll();
                    }
                }
            }
            while (!pq1.isEmpty() && pq1.peek() != 0) {
                    res += pq1.poll();
            }
            while (!pq2.isEmpty() && pq2.peek() != 0) {
                    res += pq2.poll();
                }
            return res;
        }
    }
    public static class Solution2 {
        long[][][] dp;
        public long getMinCost(int n, List<Integer> cost, List<Integer> com_1, List<Integer> com_2, int min_com) {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < n; i++) {
                sum1 += com_1.get(i);
                sum2 += com_2.get(i);
            }
            if (sum1 < min_com || sum2 < min_com) {
                return -1;
            }
//            List<List<List<Long>>> dp = new ArrayList<>();
            dp = new long[n + 1][min_com + 1][min_com + 1];
            for(long[][] inner : dp){
                for(long[] row : inner){
                    Arrays.fill(row, -1);
                }
            }
            return dfs(cost, com_1, com_2, 0, min_com, min_com);
        }

        private long dfs(List<Integer> cost, List<Integer> com_1, List<Integer> com_2, int cur, int left1, int left2) {
            if (cur == cost.size()) {
                if (left1 == 0 && left2 == 0) {
                    return 0;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            if (dp[cur][left1][left2] != -1) {
                return dp[cur][left1][left2];
            }
            int work1 = com_1.get(cur);
            int work2 = com_2.get(cur);

            // Pick current
            long pick = (long) cost.get(cur) + dfs(cost, com_1, com_2, cur + 1, Math.max(0, left1 - work1), Math.max(0, left2 - work2));

            // Not pick
            long not_pick = dfs(cost, com_1, com_2, cur + 1, left1, left2);

            dp[cur][left1][left2] = Math.min(pick, not_pick);
            return Math.min(pick, not_pick);
        }
    }
    public static List<Integer> generateCost(int n) {
        List<Integer> res = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            res.add(rand.nextInt(1000) + 1);
        }
        return res;
    }

    public static List<Integer> generateCom(int n) {
        List<Integer> res = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            res.add(rand.nextInt(2));
        }
        return res;
    }
}
