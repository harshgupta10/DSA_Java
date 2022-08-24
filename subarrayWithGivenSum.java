import java.util.*;
public class subarrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
   {

   int sum=0;
   int start=0;
   
    ArrayList<Integer> ar =new ArrayList<Integer>();
       for(int i=0;i<n;i++){
         sum = sum+arr[i];
         
         if(sum==s){
             ar.add(start+1);//starting index
             ar.add(i+1);//end index
             return ar;
             }
         else if(sum>s){
             sum =0;
             i =start;
              start++;
         }
        }
    ar.add(-1);
    return ar;  
       
   }

   public static void main(String args []){
    int arr[] = {7,7,8,12};
    int n = arr.length;
    int s = 20;
    ArrayList<Integer> a =subarraySum(arr, n, s);
    Iterator<Integer> itr = a.iterator();
    while(itr.hasNext()){
        System.out.print(itr.next()+" ");
    }
   }
}
