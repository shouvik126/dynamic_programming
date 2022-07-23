public class Solution {
	public static int countPartitions(int n, int d, int[] arr) {
		int range = 0;
        for (int i : arr) {
            range += i;
        }
        if (range < d || ((range - d) % 2) == 1) {
            // Then no partitions are possible.
            return 0;
        }
        int sum = (range + d)/2;
        return countSubsetSum(n, arr, sum);
	}
    public static int countSubsetSum(int n, int arr[], int sum) {
        int mod = (int) 1e9 + 7;
        int dp[][] = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i< sum + 1; i++) {
            dp[0][i] = 0;
        }
        
        for (int i = 1; i< n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (arr[i-1] <= j) {
                    dp[i][j] = (dp[i-1][j - arr[i-1]] + dp[i-1][j]) % mod;
                } else {
                    dp[i][j] = (dp[i-1][j]) % mod;
                }
            }
        }
        return dp[n][sum];
    }
}