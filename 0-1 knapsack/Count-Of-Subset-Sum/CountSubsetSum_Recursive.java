public class Solution {
    public static int findWays(int num[], int tar) {
        int dp[][] = new int[num.length + 1][tar + 1];
        for (int i = 0; i< num.length + 1; i++){
            for (int j = 0; j< tar + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return countSubsetSum(num.length, num, tar, dp);
    }
    public static int countSubsetSum(int n, int arr[], int sum, int dp[][]) {
        
        if (n == 0) {
            if (sum == 0)
                return 1;
            else
                return 0;
        }
        
        if (dp[n][sum] != -1)
            return dp[n][sum];
       
        if (arr[n-1] <= sum) {
            dp[n][sum] = countSubsetSum(n-1, arr, sum - arr[n-1], dp) + countSubsetSum(n-1, arr, sum, dp);
        } else {
            dp[n][sum] = countSubsetSum(n-1, arr, sum, dp);
        }
         return dp[n][sum];
    }
}