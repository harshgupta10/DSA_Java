import java.util.*;
public class minSizeSubarray {
    public static int minSubArrayLen(int target, int[] nums) {
        int sum =0;
        int l=0;
        int r=nums.length-1;
        int count=Integer.MAX_VALUE;
        while(l<=r){
            if(nums[l]<=nums[r]){
                if(target<=nums[l]+nums[r])count=Math.min(count,r-l);
                l++;
            }else{
                if(target<=nums[l]+nums[r])count=Math.min(count,r-l);
                r--;
            }
        }
        
        if(count==Integer.MAX_VALUE) return 0;
        else return ++count;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr [] = {1, 4, 45, 6, 0, 19};
        int target = 51;
        System.out.println(minSubArrayLen(target,arr));
    }
}
