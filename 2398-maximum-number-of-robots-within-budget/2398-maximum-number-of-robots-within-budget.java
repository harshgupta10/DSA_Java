class Solution {
    public int maximumRobots(int[] c1, int[] c2, long budget) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = c1.length, left = -1, ans = 0, mx = 0;
        long[] pre = new long[n];
        long sum = 0;
        
        for(int i = 0; i < n; i++){
            pre[i] = i==0?c2[i]:pre[i-1]+c2[i];
            while(!dq.isEmpty() && c1[dq.peekLast()] < c1[i])
                dq.removeLast();
            while(!dq.isEmpty() && dq.peekFirst() <= left )
                dq.removeFirst();            
            
            dq.addLast(i);
            mx = c1[dq.peekFirst()];
            sum = pre[i] - (left>=0?pre[left]:0);
            
            int k = i - left;
            long cost = mx + k * sum;
            
            while(left < i && cost > budget){
                if(!dq.isEmpty() && dq.peekFirst() == left)
                    dq.removeFirst();
                left++;
                if(!dq.isEmpty()){
                    mx = c1[dq.peekFirst()];
                    k = i - left;
                    sum = pre[i] - pre[left];
                    cost = mx + k * sum;
                }
            }
            
            if(cost <= budget)
                ans = Math.max(k, ans);            
        }
        return ans;
    }
}