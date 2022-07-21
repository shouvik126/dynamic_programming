class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        Boolean mem[][] = new Boolean[N+1][sum+1];
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    mem[i][j] = false;
                if (j == 0)
                    mem[i][j] = true;
            }
        }
        
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i-1] <= j) {
                    mem[i][j] = mem[i-1][j - arr[i-1]] ||
                                mem[i-1][j];
                } else {
                    mem[i][j] = mem[i-1][j];
                }
            }
        }
        return mem[N][sum];
    }
}