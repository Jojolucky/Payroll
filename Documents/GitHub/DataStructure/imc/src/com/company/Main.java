package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
	// write your code here
        int[] a = new int[]{2,7};
        int[] b = new int[]{9,10};
        boolean res = first(a,b,3);
        System.out.println(res);
    }

    public static boolean first(int[] a, int[] b, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(a);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            if(cur_x == b[0] && cur_y == b[1]){
                return true;
            }
            int[][] temp_arr = new int[3][2];
            temp_arr[0][0] = cur_x + cur_y;
            temp_arr[0][1] = cur_y;
            temp_arr[1][0] = cur_x;
            temp_arr[1][1] = cur_x + cur_y;
            temp_arr[2][0] = cur_x + c;
            temp_arr[2][1] = cur_y + c;
            for(int i = 0; i < 3; i++){
                double square = Math.pow(temp_arr[i][0] + temp_arr[i][1], 2);
                int root_square = (int)Math.sqrt(square);
                if(temp_arr[i][0] <= b[0] && temp_arr[i][1] <= b[0] && Math.pow(root_square,2) != square){
                    queue.add(new int[]{temp_arr[i][0], temp_arr[i][1]});
                }
            }
        }
        return false;
    }
}
