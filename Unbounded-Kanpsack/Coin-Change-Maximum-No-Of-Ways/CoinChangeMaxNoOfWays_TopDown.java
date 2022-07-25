class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        return coinChange(coins, amount, coins.length, dp);
    }
    public static int coinChange(int coins[], int amount, int n, int dp[][]) {
        for (int i = 0 ; i < n + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                if (j==0)
                    dp[i][j] = 1;
            }
        }
        
        for (int i = 1 ; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j];
                } else {
                     dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}