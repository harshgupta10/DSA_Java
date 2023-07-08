class Solution {
    public int trap(int[] height) {
        int leftMax=height[0];
        int rightMax=height[height.length-1];
        int res=0;
        int min=Integer.MAX_VALUE;
        int l=0;
        int r=height.length-1;
        while(l<r){
            if(leftMax<rightMax){
                l++;
                leftMax=Math.max(leftMax,height[l]);
                res+=leftMax-height[l];
            }
            else{
                r--;
                rightMax=Math.max(rightMax,height[r]);
                res+=rightMax-height[r];
            }
        }
        return res;
    }
}