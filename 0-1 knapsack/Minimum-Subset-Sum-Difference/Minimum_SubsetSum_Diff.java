//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    int range = 0;
	    for(int i : arr) {
	        range += i;
	    }
	    Boolean dp[][] = new Boolean[n + 1][range + 1];
	    dp[0][0] = true;
	    for (int i = 1; i < range + 1; i++) {
	        dp[0][i] = false;
	    }
	    for (int i=1; i < n + 1; i++) {
	        for (int j = 0; j < range + 1; j++) {
	            if (arr[i-1]<=j)
	                dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
	           else
	                dp[i][j] = dp[i-1][j];
	        }
	    }
	    
	    int min = Integer.MAX_VALUE;
	    for (int i = 0; i <= range/2; i++) {
	        min = Integer.min(min, range - 2*(dp[n][i] ? i : 0));
	    }
	    return min;
	} 
}
