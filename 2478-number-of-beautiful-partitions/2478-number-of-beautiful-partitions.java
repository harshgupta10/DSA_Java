class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        if (k * minLength > s.length() || !isPrime(s.charAt(0)) || isPrime(s.charAt(s.length() - 1))) {
            return 0;
        }
        int[][] dp = new int[s.length() + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 0; i < s.length() - minLength + 1; i++) {
            if (isPrime(s.charAt(i)) && (i == 0 || !isPrime(s.charAt(i - 1)))) {
                for (int j = i + minLength - 1; j < s.length(); j++) {
                    if (!isPrime(s.charAt(j))) {
                        for (int p = 0; p < k; p++) {
                            dp[j + 1][p + 1] += dp[i][p];
                            dp[j + 1][p + 1] %= 1_000_000_007;
                        }
                    }
                }
            }
        }
        return dp[s.length()][k];
    }

    private boolean isPrime(char c) {
        if (c == '2' || c == '3' || c == '5' || c == '7') {
            return true;
        }
        return false;
    }
}