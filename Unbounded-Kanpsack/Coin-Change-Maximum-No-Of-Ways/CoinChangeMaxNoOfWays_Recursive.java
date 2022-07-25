class Solution {
    public int change(int amount, int[] coins) {
        int mem[][] = new int[coins.length + 1][amount + 1];
        for (int row[] : mem) {
            Arrays.fill(row, -1);
        }
        return coinChange(coins, amount, coins.length, mem);
    }
    public static int coinChange(int coins[], int amount, int n, int mem[][]) {
        if (amount == 0)
            return 1;
        if (n == 0)
            return 0;
        
        if (mem[n][amount] != -1) {
            return mem[n][amount];
        }
        
        if (coins[n-1] <= amount) {
            mem[n][amount] = coinChange(coins, amount - coins[n-1], n, mem) + coinChange(coins, amount, n-1, mem);
        } else {
             mem[n][amount] = coinChange(coins, amount, n-1, mem);
        }
        return mem[n][amount];
    }
}