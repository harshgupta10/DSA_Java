class Solution {
    public int minPatches(int[] nums, int n) {

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int i = nums.length - 1; i >= 0; i--) stack.push(nums[i]);
        long runningSum = 0l;

        while(runningSum < n) {
            if(!stack.isEmpty() && stack.peek() <= runningSum+1) {
                runningSum += stack.pop();
            }
            else{
                count++;
                runningSum += (runningSum + 1);
            }
        }

        return count;
    }
}