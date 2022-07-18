class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    
    static int mem[][] = new int[1002][1002];
    Solution() {
        for (int[] row : mem)
            Arrays.fill(row, -1);
    }
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         if (n == 0 || W == 0){
             return 0;
         }
         if (mem[W][n] != -1)
            return mem[W][n];
            
        if (wt[n-1] <= W) {
            mem[W][n] = Math.max(val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), 
            knapSack(W, wt, val, n-1));
        } else {
            mem[W][n] = knapSack(W, wt, val, n-1);
        }
        return mem[W][n];
    } 
}
