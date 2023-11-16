public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int size = nums.length; 

        
        Arrays.sort(nums);

        int pointer = 0; 

        
        for (int i = 0; i < size; ++i) {
            
            long decimalValue = Long.parseLong(nums[i], 2);

            
            if (decimalValue == pointer)
                pointer++;
            else
                
                return String.format("%" + size + "s", Long.toBinaryString(pointer)).replace(' ', '0');
        }

        
        return String.format("%" + size + "s", Long.toBinaryString(pointer)).replace(' ', '0');
    }
}