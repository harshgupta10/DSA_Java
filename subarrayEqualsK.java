import java.util.*;
public class subarrayEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap <Integer,Integer> prefix = new HashMap<>();
        int currSum = 0;
        int count =0;
        prefix.put(0,1);

        for(int num: nums){
            currSum+=num;
            int diff = currSum-k;
            count+=prefix.getOrDefault(diff,0);
            prefix.put(currSum,prefix.getOrDefault(currSum,0)+1);
        }
        return count;
    }

    public static void main(String args[]){
        int arr[] ={1,2,3,5};
        System.out.println(subarraySum(arr,5));
    }
}
