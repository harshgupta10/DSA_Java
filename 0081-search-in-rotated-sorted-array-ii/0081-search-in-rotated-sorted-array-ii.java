class Solution {
    public boolean search(int[] nums, int target) {
        int sz = nums.length;
        int left = 0, right = sz-1;
        while(left <= right){

            int midPos = left + (right - left) / 2;
    
            if(nums[midPos] == target)return true;
            else if(nums[midPos] == nums[left] && nums[midPos] == nums[right]){
                left++;
                 right--;
            }
       
            else if(nums[midPos] >  nums[right]){ 
              if(nums[midPos] > target && nums[left] <= target){
                  right = midPos - 1;
              }else{
                  left = midPos + 1;
              }
            }else{
                if(nums[midPos] < target && nums[right] >= target){
                     left = midPos + 1;
                }else{
                     right = midPos - 1;
                }
            }
        }
        return false;
    }
}