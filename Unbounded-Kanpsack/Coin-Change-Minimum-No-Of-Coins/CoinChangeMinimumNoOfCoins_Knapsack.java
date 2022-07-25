class Solution {
    public int coinChange(int[] coins, int amount) {
        int mem[][] = new int[coins.length + 1][amount + 1];
        for (int row[] : mem) {
            Arrays.fill(row, -1);
        }
        int ans = coinChangeKanpSack(coins, coins.length, amount, mem);
        return ans == Integer.MAX_VALUE - 1 ? -1 : ans;
    }
    public static int coinChangeKanpSack(int coins[], int n , int amount, int mem[][]) {
        
        if (amount == 0)
            return 0;
        if (n == 0)
            return Integer.MAX_VALUE - 1;
        if (n == 1)
            return amount % coins[n-1] == 0 ? amount/coins[n-1] : Integer.MAX_VALUE - 1;
        
        if (mem[n][amount] != -1)
            return mem[n][amount];
        
        if (coins[n-1] <= amount) {
            mem[n][amount] = Math.min(1 + coinChangeKanpSack(coins, n, amount - coins[n-1], mem), coinChangeKanpSack(coins, n - 1, amount, mem));
        } else {
            mem[n][amount] = coinChangeKanpSack(coins, n - 1, amount, mem);
        }
        return mem[n][amount];
    }
}