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
        int mem[][] = new int[n + 1][n + 1];
        for (int row[] : mem) {
            Arrays.fill(row, -1);
        }
        return unboundKnapsack(price, length, n, n, mem);
    }
    public static int unboundKnapsack(int price[], int length[], int n, int len, int mem[][]) {
        if (n == 0 || len == 0) {
            return 0;
        }
        
        if (mem[n][len] != -1)
            return mem[n][len];
            
        if (length[n-1] <= len) {
            mem[n][len] = Math.max(price[n-1] + unboundKnapsack(price, length, n, len - length[n-1], mem ),
                                        unboundKnapsack(price, length, n-1, len, mem));
        } else {
            mem[n][len] = unboundKnapsack(price, length, n-1, len, mem);
        }
        return mem[n][len];
    }
}