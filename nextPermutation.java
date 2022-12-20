public class nextPermutation {
    public static void next_Permutation(int[] nums) {
        if(nums == null || nums.length<=1)return;
         int i = nums.length-2;
         while(i>=0 && nums[i]>=nums[i+1])i--;
         if(i>=0){
             int j = nums.length-1;
             while(nums[j]<=nums[i])j--;
             swap(nums,i,j);
         }
         reverse(nums,i+1,nums.length-1);
 
     }
 
     public static void swap(int nums[],int i, int j){
         int temp = nums[i];
          nums[i]= nums[j];
          nums[j]=temp;
     }
 
     public static void reverse(int nums[],int start, int end){
         while(start<end)swap(nums,start++,end--);
     }

     public static void main(String args[]){
        int nums[] ={1,2,3};
        next_Permutation(nums);
        int i= nums.length;
        while(i-->0)System.out.print(nums[i]+" ");
     }

}
