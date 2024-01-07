class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                count += slv(j, (long) nums[j] - (long) nums[i], nums, new int[n]);
            }
        }
        return count;
    }

    private int slv(int n, long diff, int[] nums, int[] memo) {
        if (memo[n] != 0) return memo[n];
        int count = 0;
        for (int i = n + 1; i < nums.length; i++) {
            if ((long) nums[i] - (long) nums[n] == diff) {
                count += 1 + slv(i, diff, nums, memo);
            }
        }
        return memo[n] = count;
    }
}