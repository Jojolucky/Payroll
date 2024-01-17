package amazonoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class oa2 {
    public static void main(String[] args) {
        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[]{6, 9});
        intervals.add(new int[]{2, 3});
        intervals.add(new int[]{9, 11});
        intervals.add(new int[]{1, 5});
        intervals.add(new int[]{14, 18});
        List<int[]> res = merge(intervals);
        for(int[] ar : res){
            System.out.println(ar[0] + "fff" + ar[1]);
        }
    }
    public static List<int[]> merge(List<int[]> intervals){
        Collections.sort(intervals, (a, b) -> a[0] - b[0]);
        int size = intervals.size();
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{intervals.get(0)[0], intervals.get(0)[1]});
        for(int i = 1; i < size; i++){
            int start = intervals.get(i)[0];
            int end = intervals.get(i)[1];
            if(start <= res.get(res.size() - 1)[1]){
                res.get(res.size() - 1)[1] = Math.max(end, res.get(res.size() - 1)[1]);
            }else{
                res.add(new int[]{start, end});
            }
        }
        return res;
    }
}
