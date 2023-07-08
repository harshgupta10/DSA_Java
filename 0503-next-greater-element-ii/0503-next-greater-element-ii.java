class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        Stack <Integer> stack = new Stack<>();
        int result []=new int[nums.length];
        Arrays.fill(result,-1);
        for(int i=0;i<2*n;i++){
            while(!stack.empty() && nums[i%n]>nums[stack.peek()]){
                result[stack.pop()]=nums[i%n];
            }
            if(i<n) stack.push(i);
        }
        return result;
    }
}