package airbnb;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class airbnb {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 1},
                {1, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 0}
        };
        int res = minStep(grid, 1);
        System.out.println(res);

    }
    public static int minStep(int[][] grid, int k){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0 || grid[i][j] == 1){
                    continue;
                }
                // left
                for(int left = 1; left <= k && j - left >= 0 && dp[i][j - left] != Integer.MAX_VALUE; left++){
                    int cur_col = j - left;
                    dp[i][j] = Math.min(dp[i][cur_col] + 1, dp[i][j]);
                }
                // up
                for(int up = 1; up <= k && i - up >= 0 && dp[i - up][j] != Integer.MAX_VALUE; up++){
                    int cur_row = i - up;
                    dp[i][j] = Math.min(dp[cur_row][j] + 1, dp[i][j]);
                }
            }
        }
        return dp[n - 1][m - 1];

    }
//    public static int minStep(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][][] dp = new int[m][n][3];
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(grid[i][j] == 1 || (i == 0 && j == 0)) continue;
//                int left_min = (j == 0 || grid[i][j - 1] == 1) ? Integer.MAX_VALUE : dp[i][j - 1][1];
//                int up_min = (i == 0 || grid[i - 1][j] == 1)? Integer.MAX_VALUE : dp[i - 1][j][2];
//                int cur_min = Math.min(left_min, up_min);
//                int cur = cur_min == Integer.MAX_VALUE ? Integer.MAX_VALUE : cur_min + 1;
//                dp[i][j][0] = cur;
//                dp[i][j][1] = Math.min(left_min, cur);
//                dp[i][j][2] = Math.min(up_min, cur);
//            }
//        }
//        int res = dp[m - 1][n - 1][0];
//        if(res == Integer.MAX_VALUE) {
//            return -1;
//        }else {
//            return res;
//        }
//    }
}