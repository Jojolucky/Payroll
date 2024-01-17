package second;

import java.util.LinkedList;
import java.util.Queue;

public class light {
    public static void main(String[] args) {
        int[] a = new int[]{0,0,1,3,4,6,6,7,7,8,8,12,14,15,16,16,17};
        int[] b = new int[]{0,1,1,1,0,0,1,0,1,0,1,0,0,1,0,1,0};
        second(a,b);
//        System.out.println(second(a,b));
        int sgg= 0;
    }

    public static int[] second(int[] time, int[] lane){
        int[] res = new int[time.length];
        Queue<Integer> main_trail = new LinkedList<>();
        Queue<Integer> first = new LinkedList<>();

        for(int i = 0; i < time.length; i++){
            if(lane[i] == 0){
                main_trail.add(i);
            }else{
                first.add(i);
            }
        }
        int cur_time = 0;
        int last_sec = 1;
        while(!main_trail.isEmpty() && !first.isEmpty()){
            int main_t = time[main_trail.peek()];
            int first_t = time[first.peek()];
            if(cur_time < Math.min(main_t, first_t)){
                cur_time = Math.min(main_t, first_t);
                last_sec = 1;
            }
            else if(cur_time < main_t){
                res[first.poll()] = cur_time;
                cur_time++;
                last_sec = 1;
            }else if(cur_time < first_t){
                res[main_trail.poll()] = cur_time;
                cur_time++;
                last_sec = 0;
            }else{
                if(last_sec == 1){
                    res[first.poll()] = cur_time;
                    cur_time++;
                    last_sec = 1;
                }else{
                    res[main_trail.poll()] = cur_time;
                    cur_time++;
                    last_sec = 0;
                }
            }
        }
        while(!main_trail.isEmpty()){
            res[main_trail.peek()] = Math.max(cur_time++, time[main_trail.peek()]);
            main_trail.poll();
        }
        while(!first.isEmpty()){
            res[first.peek()] = Math.max(cur_time++, time[first.peek()]);
            first.poll();
        }
        return res;
    }
}
