//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{

    static Boolean mem[][] = new Boolean[102][100002];
    Solution() {
    }
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
        if (sum == 0)
            return true;
        if (N==0) 
            return false;
            
        if (mem[N][sum] != null)
            return mem[N][sum];
            
        if (arr[N-1] <= sum) {
            mem[N][sum] = isSubsetSum(N-1, arr, sum - arr[N-1]) || isSubsetSum(N-1, arr, sum);
        } else {
            mem[N][sum] = isSubsetSum (N-1, arr, sum);
        }
        return mem[N][sum];
    }
}