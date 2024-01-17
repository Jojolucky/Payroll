package blackrock;

import javafx.util.Pair;

import java.util.*;

public class currencyExchange {
    public static void main(String[] args) {
//        List<List<String>> equations = new ArrayList<>();
//        List<String> a = new ArrayList<>();
//        a.add("a");
//        a.add("b");
//        List<String> b = new ArrayList<>();
//        b.add("b");
//        b.add("c");
//        equations.add(a);
//        equations.add(b);
//
//        double[] values = new double[]{2.0,3.0};
//        List<List<String>> queries = new ArrayList<>();
//        List<String> c = new ArrayList<>();
//        c.add("a");
//        c.add("c");
//        List<String> d = new ArrayList<>();
//        d.add("b");
//        d.add("a");
//        List<String> e = new ArrayList<>();
//        e.add("a");
//        e.add("e");
//        List<String> f = new ArrayList<>();
//        f.add("a");
//        f.add("a");
//        List<String> g = new ArrayList<>();
//        g.add("x");
//        g.add("x");
//        queries.add(c);
//        queries.add(d);
//        queries.add(e);
//        queries.add(f);
//        queries.add(g);


        String input = "USD,CAD,1.3;USD,GBP,0.71;USD,JPY,109;GBP,JPY,155";

//        String input = "USD,GBP,0.7;USD,JPY,109;GBP,JPY,155;CAD,CNY,5.27;CAD,KRW,921";
        // operate input
        String[] inputArr = input.split(";");
        List<List<String>> equations = new ArrayList<>();
        List<String> queries = new ArrayList<>();
        List<Double> values = new ArrayList<>();
        for(String s : inputArr){
            String[] ss = s.split(",");
            equations.add(Arrays.asList(ss[0], ss[1]));
            values.add(Double.valueOf(ss[2]));
        }
        queries.add("USD");
//        queries.add("CNY");
        queries.add("JPY");


        double res = calcEquation(equations, values, queries);
        System.out.println(res);

    }
    public static double calcEquation(List<List<String>> equations, List<Double> values, List<String> queries) {
        // create a graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values.get(i);
            graph.computeIfAbsent(a, start -> new HashMap<>()).put(b, val);
            graph.computeIfAbsent(b, start -> new HashMap<>()).put(a, 1 / val);
        }

        String a = queries.get(0);
        String b = queries.get(1);
        List<Double> res = bfs(graph, a, b);
        // return res
        if(res.isEmpty()) return -1.0;
        double max = 0;
        for(double i : res){
            max = Math.max(max, i);
        }
        return max;
    }

    private static List<Double> bfs(Map<String, Map<String, Double>> graph, String start, String end) {
        Queue<Pair<String, Double>> queue = new LinkedList<>();
        queue.offer(new Pair<>(start, 1.0));
        Set<String> seen = new HashSet<>();
        List<Double> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<String, Double> pair = queue.poll();
                String node = pair.getKey();
                double res = pair.getValue();
                // meet the end, add the cur answer
                if (node.equals(end)) {
                    ans.add(res);
                    continue;
                }
                seen.add(node);

                for (Map.Entry<String, Double> neighbor : graph.get(node).entrySet()) {
                    String n = neighbor.getKey();
                    double val = neighbor.getValue();
                    if (!seen.contains(n)) {
                        queue.offer(new Pair<>(n, res * val));
                    }
                }
            }
        }
        return ans;
    }
}
