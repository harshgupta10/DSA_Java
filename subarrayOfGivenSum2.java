import java.util.*;
public class subarrayOfGivenSum2 {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
   {
    ArrayList<Integer> ar = new ArrayList<Integer>();
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    int sum =0;
    
    for(int i=0;i<n;i++){
        sum+=arr[i];
        if(sum-s==0){
            ar.add(0);
            ar.add(i);
            return ar;
        }
        if(map.containsKey(sum-s)){
            ar.add(map.get(sum-s)+1);
            ar.add(i);
            return ar;
        }
        else{
            map.put(sum,i);
        }
    }
    ar.add(-1);
    return ar;
}

    public static void main(String args []){
    int arr[] = {7,7,8,12};
    int n = arr.length;
    int s = -1;
    ArrayList<Integer> a =subarraySum(arr, n, s);
    Iterator<Integer> itr = a.iterator();
    while(itr.hasNext()){
        System.out.print(itr.next()+" ");
    }
   
    }

}
