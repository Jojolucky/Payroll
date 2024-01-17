package tiktokoa;

import java.util.Arrays;

// TASK

public class OA202309N4 {
    public static void main(String[] args) {
        int count = 3;
        int[] priority = {3, 1, 2};
        int x = 5;
        int y = 7;
        int res = findMaxSum(count, priority, x, y);
        System.out.println(res);
    }
    public static int findMaxSum(int count, int[] priority, int x, int y){
        Arrays.sort(priority);
        int cycles = y / x;
        int remain = y % x;
        // calculate the score in one cycle
        int singleScore = 0;
        int length = Math.min(count, x);
        int index = count - 1;
        while( length > 0 && index >= 0){
            singleScore += priority[index];
            index--;
            length--;
        }

        // calculate the total score of all cycles
        int totalScore = singleScore * cycles;
        // calculate the score of the remaining
        index = count - 1;
        while(remain > 0 && index >= 0){
            totalScore += priority[index];
            index--;
            remain--;
        }
        return totalScore;
    }
}
