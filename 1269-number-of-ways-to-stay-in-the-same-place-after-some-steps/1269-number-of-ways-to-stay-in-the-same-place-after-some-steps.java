class Solution {
    public int numWays(int steps, int arrLen) {
        int MOD = 1000000007;
        
        // Since the maximum number of steps is 500, and arrLen can be at most 500,
        // we only need to consider arrLen + 1 positions (0 to arrLen).
        int maxPos = Math.min(steps / 2, arrLen - 1);
        
        // dp[i][j] represents the number of ways to reach position j after i steps.
        int[][] dp = new int[steps + 1][maxPos + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxPos; j++) {
                dp[i][j] = dp[i - 1][j];  // Stay in the same place
                
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;  // Move left
                }
                
                if (j < maxPos) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MOD;  // Move right
                }
            }
        }
        
        return dp[steps][0];
    }
}
