public class Solution {
    public static int findWays(int num[], int tar) {
        
        return countSubsetSum(num.length, num, tar);
    }
    public static int countSubsetSum(int n, int arr[], int sum) {
        int dp[][] = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i< sum + 1; i++)
            dp[0][i] = 0;
        for (int i = 1 ; i< n +1; i++) {
            for (int j = 0; j< sum + 1; j++) {
                if (arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
         return dp[n][sum];
    }
}