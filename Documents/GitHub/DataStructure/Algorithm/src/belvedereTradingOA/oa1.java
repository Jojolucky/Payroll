package belvedereTradingOA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class oa1 {
    public static void main(String[] args) throws IOException, IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        String input = new String();
        while((line = in.readLine()) != null){
            if(line.equals("exit")){
                break;
            }
            System.out.println(line);
            input = line;
        }
        transfer(input);
    }

    public static void transfer(String input){
        //
        List<String> keys = new ArrayList<>();
        List<Double> values = new ArrayList<>();
        List<Integer> quan = new ArrayList<>();
        List<Integer> serials = new ArrayList<>();

        String[] queries = input.split(";");
        for(String q : queries){
            String[] details = q.split(",");
            keys.add(details[0]);
            values.add(Double.parseDouble(details[1]));
            quan.add(Integer.parseInt((details[2])));
            serials.add(Integer.parseInt(details[3]));
        }

        //
        Map<String, Double> total_value = new HashMap<>();
        Map<String, Integer> total_count = new HashMap<>();
        int cur_serial = 0;
        for(int i = 0; i < keys.size(); i++){
            // if the second serial is smaller than the previous one, it would skip
            if(serials.get(i) < cur_serial){
                continue;
            }
            cur_serial = serials.get(i);
            String cur_key = keys.get(i);
            double cur_value = total_value.getOrDefault(cur_key, 0.0) + values.get(i) * quan.get(i);
            Integer cur_cnt = total_count.getOrDefault(cur_key, 0) + quan.get(i);
            total_count.put(cur_key, cur_cnt);
            total_value.put(cur_key, cur_value);
            double cut_output = round(cur_value / cur_cnt);
            printKeyAndWMA(Integer.valueOf(cur_key), cut_output);
        }
    }
    static double round(double in){
        int tem = (int)(in * 100);
        return (double) tem / 100;

    }
    public static void printKeyAndWMA(int key, double weightedMovingAverage){
        System.out.printf("%d: %.2f\n", key, weightedMovingAverage);
    }

}
