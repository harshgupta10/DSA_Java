class Solution {
    public long kSum(int[] nums, int k) {
       long max = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > 0)
                max += nums[i];
            else
                nums[i] = -nums[i];
        }
        Arrays.sort(nums);
        PriorityQueue<long[]> que = new PriorityQueue<>((n1, n2) -> (Long.compare(n1[0], n2[0])));
        que.offer(new long[]{nums[0], 0});

        long kmin = 0;
        for (int i = 1; i < k; i ++) {
            long[] node = que.poll();
            kmin = node[0];
            if (node[1] == nums.length - 1)
                continue;
            que.offer(new long[] {kmin + nums[(int)node[1]+1], node[1]+1});
            que.offer(new long[] {kmin - nums[(int)node[1]] + nums[(int)node[1]+1], node[1]+1});
        }
        
        return max - kmin; 
    }
}