package tiktokoa;

import java.util.*;

public class OA202309N52 {
    public static void main(String[] args) {
//        List<List<Integer>> seat = new ArrayList<>();
//        for(int i = 0; i < 5; i++){
//            seat.add(Arrays.asList(0,0,0,0,0));
//        }
//        List<List<Integer>> seat1 = new ArrayList<>();
//        for(int i = 0; i < 5; i++){
//            seat1.add(Arrays.asList(0,0,0,0,0));
//        }
//        List<List<Integer>> q = new ArrayList<>();
//        q.add(Arrays.asList(1,2,3));
//        q.add(Arrays.asList(0,2,4));
//        q.add(Arrays.asList(2,0,2));
//        for(int i = 0; i < q.size(); i++){
//            Solution1 s1 = new Solution1();
//            Solution s = new Solution();
//            s1.init(seat1);
//            s.init(seat);
//            boolean res1 = s1.bookSeat(q.get(i).get(0), q.get(i).get(1), q.get(i).get(2));
//            boolean res = s.bookSeat(q.get(i).get(0), q.get(i).get(1), q.get(i).get(2));
//            System.out.println("s1 " + res1 + "  s:" + res);
//
//        }

//        while (true) {
//            Random rand = new Random();
//            int n = rand.nextInt(15) + 1;
//            int m = rand.nextInt(15) + 1;
//            int t = rand.nextInt(10) + 1;
//            List<List<Integer>> map = genMap(n, m);
//            List<List<Integer>> map1 = new ArrayList<>(map);
//            List<List<Integer>> qs = new ArrayList<>();
//            for (int i = 0; i < t; i++) {
//                qs.add(genQuery(n, m));
//            }
//            Solution sol = new Solution();
//            Solution1 sol1 = new Solution1();
//            sol.init(map);
//            sol1.init(map1);
//            if (map.size() == 1 && map.get(0).size() == 1) {
//                System.out.println(1);
//            }
//            for (int i = 0; i < qs.size(); i++) {
//                boolean s1 = sol.bookSeat(qs.get(i).get(0), qs.get(i).get(1), qs.get(i).get(2));
//                boolean s2 = sol1.bookSeat(qs.get(i).get(0), qs.get(i).get(1), qs.get(i).get(2));
//                System.out.println("solution1: " + s1);
//                System.out.println("solution2: " + s2);
//                if (s1 != s2) {
//                    System.out.println("error");
//                    for (List<Integer> mRow : sol1.seating) {
//                        for (Integer nVal : mRow) {
//                            System.out.print(nVal + " ");
//                        }
//                        System.out.println();
//                    }
//                    System.out.println(qs.get(i).get(0) + " " + qs.get(i).get(1) + " " + qs.get(i).get(2));
//                    boolean aa = sol.bookSeat(qs.get(i).get(0), qs.get(i).get(1), qs.get(i).get(2));
//                    boolean bb = sol1.bookSeat(qs.get(i).get(0), qs.get(i).get(1), qs.get(i).get(2));
//                    return;
//                }
//                if (s1) {
//                    System.out.println("1111111111111111111111111111111");
//                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//                }
//            }
//        }
    }

    public static List<Integer> genQuery(int n, int m) {
        Random rand = new Random();
        int row = rand.nextInt(n);
        int col = rand.nextInt(m);
        int count = rand.nextBoolean() ? (m - col - 1) : (rand.nextInt(m - col) + 1);
        List<Integer> query = new ArrayList<>();
        query.add(row);
        query.add(col);
        query.add(count);
        return query;
    }

    public static List<List<Integer>> genMap(int n, int m) {
        List<List<Integer>> ini = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(0);
            }
            ini.add(row);
        }
        Random rand = new Random();
        int times = rand.nextInt(30);
        Solution sol = new Solution();
        sol.init(ini);

        for (int i = 0; i < times; i++) {
            List<Integer> q = genQuery(n, m);
            sol.bookSeat(q.get(0), q.get(1), q.get(2));
        }

        return sol.seating;
    }
}


class Solution1 {
    List<List<Integer>> seating;
    private Map<Integer, TreeSet<Integer>> map;

    public void init(List<List<Integer>> initialSeats) {
        seating = initialSeats;
        map = new HashMap<>();
        for (int row = 0; row < initialSeats.size(); row++) {
            int start = Integer.MAX_VALUE;
            int end = -1;
            for (int i = 0; i < initialSeats.get(row).size(); i++) {
                if (initialSeats.get(row).get(i) == 1) {
                    start = Math.min(start, i);
                    end = Math.max(end, i);
                }
            }
            TreeSet<Integer> seatSet = new TreeSet<>();
            if(start != Integer.MAX_VALUE && end != -1){
                seatSet.add(start);
                seatSet.add(end);
            }
            map.put(row, seatSet);
        }
    }

    public boolean bookSeat(int row, int col, int count) {
        if (row >= 0 && row < seating.size()) {
            int numCols = seating.get(0).size();
            if (col >= 0 && col + count <= numCols) {
                int start = col;
                int end = col + count - 1;
                int left = seating.get(row).get(0);
                int right = seating.get(row).get(numCols - 1);

                // If full
                if (left != 0 && right != 0) {
                    return false;
                }
                // Else if empty
                else if (left == 0 && right == 0) {
                    if (start != 0 && end != numCols - 1) {
                        return false;
                    }
                }
                // Else: right occupied
                else if (left == 0) {
                    TreeSet<Integer> seatRow = new TreeSet<>(map.get(row));
                    Integer upper = seatRow.higher(end);
                    Integer lower = seatRow.floor(end);

                    if (upper == null || upper != end + 1) {
                        return false;
                    }
                    if (lower != null) {
                        return false;
                    }
                }
                // Else: left occupied
                else {
                    TreeSet<Integer> seatRow = new TreeSet<>(map.get(row));
                    Integer upper = seatRow.ceiling(start);
                    Integer lower = seatRow.lower(start);
                    if (lower == null || lower != start - 1) {
                        return false;
                    }
                    if (upper != null) {
                        return false;
                    }
                }
                map.get(row).add(start);
                map.get(row).add(end);
//                for (int i = start; i <= end; i++) {
//                    seating.get(row).set(i, 1);
//                }
                seating.get(row).set(start, 1);
                seating.get(row).set(end, 1);
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public List<List<Integer>> seating;

    public void init(List<List<Integer>> initialSeats) {
        seating = new ArrayList<>(initialSeats);
    }

    public boolean bookSeat(int row, int col, int count) {
        if (row >= 0 && row < seating.size()) {
            int numCols = seating.get(0).size();
            if (col >= 0 && col + count <= numCols) {
                //
                int start = col;
                int end = col + count - 1;

                int left = seating.get(row).get(0);
                int right = seating.get(row).get(numCols - 1);

                // If full
                if (left != 0 && right != 0) {
                    return false;
                }
                // Else if empty
                else if (left == 0 && right == 0) {
                    if (start != 0 && end != numCols - 1) {
                        return false;
                    }
                }
                // Else: right occupied
                else if (left == 0) {
                    if (seating.get(row).get(end) == 1 || end == numCols - 1 || seating.get(row).get(end + 1) == 0) {
                        return false;
                    }
                }
                // Else: left occupied
                else {
                    if (seating.get(row).get(start) == 1 || start == 0 || seating.get(row).get(start - 1) == 0) {
                        return false;
                    }
                }

                for (int i = col; i <= end; i++) {
                    seating.get(row).set(i, 1);
                }
                return true;
            }
        }
        return false;
    }
}

