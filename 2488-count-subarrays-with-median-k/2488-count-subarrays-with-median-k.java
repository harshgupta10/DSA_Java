class Solution {

    
    public int countSubarrays(int[] nums, int k) {
        int ind = 0;
        for (ind = 0; ind < nums.length; ind++) {
            if (nums[ind] == k) {
                break;
            }
        }

        int[] diffs = new int[nums.length + 2];

        int diff = 0;
        for (int i = ind; i < nums.length; i++) {
            if (nums[i] > k) {
                diff++;
            } else if (nums[i] < k) {
                diff--;
            }
            diffs[k + diff]++;
        }

        int count = diffs[k] + diffs[k + 1];
        diff = 0;
        for (int i = ind - 1; i >= 0; i--) {
            if (nums[i] > k) {
                diff++;
            } else if (nums[i] < k) {
                diff--;
            }
            if (k - diff >= 0 && k - diff < diffs.length) {
                count += diffs[k - diff];
            }
            if (k - diff + 1 >= 0 && k - diff + 1 < diffs.length) {
                count += diffs[k - diff + 1];
            }
        }

        return count;
    }
}