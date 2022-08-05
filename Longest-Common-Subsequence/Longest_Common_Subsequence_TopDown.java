class Solution {
    private static int dp[][] = new int[1001][1001]; 
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceRecursive(text1, text2, text1.length(), text2.length());
    }
    
    public static int longestCommonSubsequenceRecursive(String text1, String text2, int n, int m) {
        for (int i = 0 ; i < n + 1; i++) {
            for (int j = 0; j< m + 1; j++) {
                if (i == 0 || j == 0 )
                    dp[i][j] = 0;
            }
        }
        
        for (int i = 1 ; i < n + 1; i++) {
            for (int j = 1; j< m + 1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];    
    }
}