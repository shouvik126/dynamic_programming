class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int mem[][] = new int[n+1][W+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j< W+1; j++) {
                if (i==0 || j==0)
                    mem[i][j] = 0;
            }
        }
        
        for (int i = 1; i< n+1; i++) {
            for (int j = 1; j< W+1; j++) {
                if (wt[i-1] <= j) {
                    mem[i][j] = Math.max(val[i-1] + mem[i-1][j - wt[i-1]],
                        mem[i-1][j]);
                } else {
                    mem[i][j] = mem[i-1][j];
                }
            }
        }
        return mem[n][W];
    } 
}