public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        int maxLength = 0;

        // Base case: all substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans = s.substring(i, i+1);
            maxLength = 1;
        }

        // Fill in the dp table for substrings of length 2 and greater
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n-len+1; i++) {
                int j = i+len-1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || dp[i+1][j-1]) {
                        dp[i][j] = true;
                        if (len > maxLength) {
                            ans = s.substring(i, i+len);
                            maxLength = len;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
