//{ Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        int length[] = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }
        int dp[][] = new int[n + 1][n + 1];
        return unboundKnapsack(price, length, n, n, dp);
    }
    public static int unboundKnapsack(int price[], int length[], int n, int len, int dp[][]) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < len + 1; j++) {
                if (i==0 || j==0)
                    dp[i][j] = 0;
            }
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < len + 1; j++) {   
                if (length[i-1] <= j) {
                    dp[i][j] = Math.max(price[i-1] + dp[i][j - length[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][len];
    }
}