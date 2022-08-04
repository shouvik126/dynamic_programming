class Solution {
    private static int mem[][] = new int[1001][1001]; 
    public int longestCommonSubsequence(String text1, String text2) {
        for (int []arr : mem) {
            Arrays.fill(arr, -1);
        }
        return longestCommonSubsequenceRecursive(text1, text2, text1.length(), text2.length());
        
    }
    
    public static int longestCommonSubsequenceRecursive(String text1, String text2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        
        if (mem[n][m] != -1) {
            return mem[n][m];
        }
        if (text1.charAt(n-1) == text2.charAt(m-1)) {
            return mem[n][m] = 1 + longestCommonSubsequenceRecursive(text1, text2, n-1, m-1);
        } else {
            return mem[n][m] = Math.max(longestCommonSubsequenceRecursive(text1, text2, n-1, m), longestCommonSubsequenceRecursive(text1, text2, n, m-1));
        }
    }
}