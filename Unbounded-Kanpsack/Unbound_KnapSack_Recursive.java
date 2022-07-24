//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
       int mem[][] = new int [N+1][W+1];
       for (int row[] : mem) {
           Arrays.fill(row, -1);
       }
       return knapSackRecursive(N, W, val, wt, mem);
    }
    
    public static int knapSackRecursive(int n, int w, int val[], int wt[], int mem[][]) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (mem[n][w] != -1)
            return mem[n][w];
        
        if (wt[n-1] <= w) {
            mem[n][w] = Math.max(val[n-1] + knapSackRecursive(n, w - wt[n-1], val, wt, mem), knapSackRecursive(n-1, w, val, wt, mem));
        } else {
            mem[n][w] = knapSackRecursive(n-1, w, val, wt, mem);
        }
        return mem[n][w];
    }
}