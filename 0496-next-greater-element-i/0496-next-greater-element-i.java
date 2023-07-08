class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap <Integer,Integer> map = new HashMap <>();
        Stack <Integer> stack = new Stack<>();
        int result[] = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],i);
            result[i]= -1;
        }
        
        for(int i=0;i<nums2.length;i++){
            int curr = nums2[i];
            while(!stack.empty() && curr>stack.peek()){
                int val = stack.pop();
                result[map.get(val)]=curr;
            }
            if(map.containsKey(curr)) stack.push(curr);
        }
        return result;
    }
}