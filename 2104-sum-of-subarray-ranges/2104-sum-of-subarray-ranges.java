class Solution {
    public long subArrayRanges(int[] nums) {
        long res=0;
        int n = nums.length,j,k;
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<=n;i++){
            while(!s.empty() && nums[s.peek()]>(i == n ? Integer.MIN_VALUE : nums[i])){
                 j=s.pop();
                 k = s.isEmpty() ? -1 : s.peek();
                res -= (long)nums[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        s.clear();
         
            for(int i=0;i<=n;i++){
            while(!s.empty() && nums[s.peek()]<(i == n ? Integer.MAX_VALUE : nums[i])){
                j=s.pop();
                 k = s.isEmpty() ? -1 : s.peek();
                res += (long)nums[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        return res;
    }
}