import java.util.*;
public class duplicatesInArray {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList <Integer> a = new ArrayList<Integer>();
        int j = 0;
        int i =1;
        int prev =arr[0];
         for(;i<n;i++){
             if(arr[i]==arr[j]){
                 
                 a.add(arr[i]);
                 j++;
                 i=j+1;
             }
             else if(i==n-1){
                 j++;
                 i=j+1;
             }
         }
         Collections.sort(a);
         if(a.size()==0){
             a.add(-1);
             return a;
         }
         else
             return a;
     }
}
