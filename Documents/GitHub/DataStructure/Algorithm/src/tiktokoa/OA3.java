package tiktokoa;

public class OA3 {
    public static void main(String[] args) {
        int[][] forest = {{1,2,3},{2,1,2},{3,1,1}};
        int people = 3;
        int res = ways(forest, people);
        System.out.println(res);
    }
    static int mod = 1000000007;
    public static int ways(int[][] forest, int people){
        int m = forest.length;
        int n = forest[0].length;
        Integer[][][] dp = new Integer[people][m][n];
        int[][] preSum = new int[m + 1][n + 1];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                preSum[i][j] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i + 1][j + 1] + (forest[i][j] == 2 ? 1 : 0);
            }
        }
        return dfs(people - 1, m, n, 0, 0, dp, preSum);
    }
    public static int dfs(int people, int m, int n, int row, int col, Integer[][][] dp, int[][] preSum){
        if(preSum[row][col] == 0) return 0;
        if(people == 0) return 1;
        if(dp[people][row][col] != null) return dp[people][row][col];
        //vertical
        int ans = 0;
        for(int new_row = row + 1; new_row < m; new_row++){
            if(preSum[row][col] - preSum[new_row][col] >= 1){
                ans = (ans + dfs(people - 1, m, n, new_row, col, dp, preSum))% mod;
            }
        }
        for(int new_col = col + 1; new_col < n; new_col++){
            if(preSum[row][col] - preSum[row][new_col] >= 1){
                ans = (ans + dfs(people - 1, m, n, row, new_col, dp, preSum)) % mod;
            }
        }
        dp[people][row][col] = ans;
        return dp[people][row][col];
    }
}
