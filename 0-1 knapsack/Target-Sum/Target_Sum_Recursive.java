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
        int mem[][] = new int[nums.length + 1][Math.abs(sum) + 1];
        for (int i=0; i<nums.length + 1; i++) {
            for (int j = 0; j< Math.abs(sum) + 1; j++) {
                mem[i][j] = -1;
            }
        }
        return countSubsetSum(nums.length, nums, sum, mem);
    }
    public static int countSubsetSum(int n, int arr[], int sum, int dp[][]) {
        if (n == 0) {
            if (Math.abs(sum) == 0)
                return 1;
            else
                return 0;
        }
        
        if (arr[n-1] <= Math.abs(sum)) {
            dp[n][Math.abs(sum)] = countSubsetSum(n-1, arr, Math.abs(sum) - arr[n-1], dp) + countSubsetSum(n-1, arr, Math.abs(sum), dp);
        } else {
            dp[n][Math.abs(sum)] = countSubsetSum(n-1, arr, Math.abs(sum), dp);
        }
        return dp[n][Math.abs(sum)];
    }
}