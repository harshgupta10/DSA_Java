class Solution {

    HashSet<Integer>[][] dp;

    public int scoreOfStudents(String s, int[] answers) {
        int correct = evaluateExp(s);
        dp = new HashSet[s.length()][s.length()];
        HashSet<Integer> set = dfs(0, s.length()-1, s);
        int res = 0;
        for (int a : answers) {
            res += ( (a==correct) ? 5 : set.contains(a) ? 2 : 0 );
        }
        return res;
    }

    public HashSet<Integer> dfs(int l, int r, String s) {
        if (dp[l][r] != null) {
            return dp[l][r];
        }

        dp[l][r] = new HashSet<>();

        if (l == r) {
            dp[l][r].add(s.charAt(l)-'0');
            return dp[l][r];
        }

        for (int i = l+1; i < r; i += 2) {
            for (int k : dfs(l, i-1, s)) {
                for (int m : dfs(i+1, r, s)) {
                    int n = (s.charAt(i) == '+') ? k+m : k*m;
                    if (n <= 1000) {
                        dp[l][r].add(n);
                    }
                }
            }
        }
        return dp[l][r];
    }

    public int evaluateExp(String s) {
        int correct = 0;
        int prev = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '*') {
                op = s.charAt(i);
                continue;
            }
            int current = s.charAt(i)-'0';
            if (op == '+') {
                correct += prev;
                prev = current;
            } else {
                prev *= current;
            }
        }
        correct += prev;
        return correct;
    }
}