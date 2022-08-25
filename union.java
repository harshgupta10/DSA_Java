//union operation using hashset
import java.util.*;
class union{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        
        HashSet <Integer> hs = new HashSet<Integer>();
        
        for(int i=0;i<n;i++){
            hs.add(a[i]);
        }
        
        for(int j=0;j<m;j++){
            hs.add(b[j]);
        }
        
        return hs.size();
    }

    public static void main(String args []){
        int a[] = {4,3,2,11,6,9};
        int b[] = {44,3,11,2};
       System.out.println(doUnion(a, a.length, b, b.length)); 
        
       
    }
}