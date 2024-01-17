package expedia;

import java.util.Collections;
import java.util.PriorityQueue;

public class bankTransaction {
    public static void main(String[] args) {
        int[] arr = {3,2,-5,-6,-1,-2,4,-4,-1,-2};
        int res = maxNumberOfTransaction(arr);
        System.out.println(res);

    }
    public static int maxNumberOfTransaction(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0;
        int remain_sum = 0;
        for(int i = 0; i < arr.length; i++) {
            // if negative, push element into heap
            if (arr[i] < 0) {
                pq.offer(arr[i]);
            }
            // if positive
            else {
                //    1. while loop to pop biggest negatives and update the remain and res
                while (!pq.isEmpty() && remain_sum + pq.peek() >= 0) {
                    remain_sum += pq.poll();
                    res++;
                }
                //    1.1  clear the pq
                pq.clear();
                //    2. deal with the cur positive and update the remain and res
                remain_sum += arr[i];
                res++;
            }
        }
        while (!pq.isEmpty() && remain_sum + pq.peek() >= 0) {
            remain_sum += pq.poll();
            res++;
        }
        return res;
    }
}
