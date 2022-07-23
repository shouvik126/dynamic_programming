class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int range = 0;
        for (int i : nums) {
            range += i;
        }
        if (range < target || (range - target)%2 == 1)
        {
            return 0;
        }
        int sum = (range + target)/2;
        return countSubsetSum(nums.length, nums, sum);
    }
    public static int countSubsetSum(int n, int arr[], int sum) {
        int dp[][] = new int[n + 1][Math.abs(sum) + 1];
        dp[0][0] = 1;
        for (int i = 1; i<sum + 1; i++) {
            dp[0][i] = 0;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (arr[i-1] <= j) {
                    dp [i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][Math.abs(sum)];
    }
}