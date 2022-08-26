import java.util.*;
public class pairOfSum {
    static int getPairsCount(int[] arr, int n, int k) {
        int count=0;
        HashMap <Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            if(m.containsKey(k-arr[i])){
                count+=m.get(k-arr[i]);
            }
            //simple frequency code after this
            if(m.containsKey(arr[i])){
                m.put(arr[i],m.get(arr[i])+1);
            }
            else{
                m.put(arr[i],1);
            }
        }
        return count;
        
    }

    public static void main(String args []){
        int arr[]= {1,5,7,1};
        int k = 6;
        System.out.println(getPairsCount(arr,arr.length,k));
    }
}
