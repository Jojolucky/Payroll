package tiktokoa;

import java.util.*;

public class OA4 {
    public static void main(String[] args) {
//        int[] candy = {1,2,1};
//        int res = findMax(candy);
//        System.out.println(res);

//        int[] nums = {3, 1, 2, 5, 4};
//        System.out.println(exchangeCups(nums));

        int[][] tasks = {{1,3,2}, {2,5,3}, {5,6,2},{1,7,5}};
        System.out.println(processingTask(tasks));
    }
    public static int processingTask(int[][] tasks){
        HashSet<Integer> time = new HashSet<>();
        // sort the tasks
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(int i = 0; i < tasks.length; i++){
            int start = tasks[i][0];
            int end = tasks[i][1];
            int period = tasks[i][2];
            //
            for(int j = start; j <= end; j++){
                if(time.contains(j)){
                    period--;
                }
            }
            //
            while(period > 0){
                if(!time.contains(end)){
                    time.add(end);
                    period--;
                }
                end--;
            }
        }
        return time.size();
    }
    public static int processingTask2(int[][] tasks){
//        int max_time = 0;
//        for(int[] a : tasks){
//            max_time = Math.max(max_time, a[1]);
//        }
//        System.out.println(max_time);
        int[] used = new int[10000000];
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cnt = 0;
        for(int i = 0; i < tasks.length; i++){
            int start = tasks[i][0];
            int end = tasks[i][1];
            int period = tasks[i][2];
            //
            for(int j = start; j <= end; j++){
                if(used[j] == 1){
                    period--;
                }
            }
            //
            while(period > 0){
                if(used[end] == 0){
                    used[end] = 1;
                    period--;
                    cnt++;
                }
                end--;
            }
        }
        return cnt;
    }
    public static int exchangeCups(int[] nums){
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i + 1){
                // swap the ith element with the (nums[i] - 1)th element
                int tem = nums[i];
                nums[i] = nums[tem - 1];
                nums[tem - 1] = tem;
                //
                res++;
            }
        }
        return res;
    }
    public static int findMax(int[] candy){
        int size = candy.length;
        // left and right represents the last candies that are eaten
        int left = 0, right = size - 1;
        int preSum = candy[left];
        int postSum = candy[right];
        int max = 0;
        while(left < right) {
            if (preSum == postSum) {
                // update result
                max = left - 0 + 1 + (size - 1 - right + 1);
                left++;
                right--;
                // start to eat new candies
                preSum += candy[left];
                postSum += candy[right];
            }
            else if (preSum < postSum) {
                left++;
                preSum += candy[left];
            }
            else if (preSum > postSum) {
                right--;
                postSum += candy[right];
            }
        }
        return max;
    }
}
