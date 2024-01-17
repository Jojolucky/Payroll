package tiktokoa;

import java.rmi.MarshalException;
import java.util.Arrays;

public class OA2 {
    public static void main(String[] args) {
        int r = 5 ;
        int[] arr = {3, 5};
        int res = findMinNumber(r, arr);
        System.out.println(res);

    }
    public static int findMinNumber(int requirement, int[] arr){
        int[] dp = new int[requirement + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < requirement + 1; i++){
            for(int j = 0; j < arr.length; j++){
                if(i - arr[j] >= 0 && dp[i - arr[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }
        return dp[requirement] == Integer.MAX_VALUE ? -1 : dp[requirement];
    }
}
