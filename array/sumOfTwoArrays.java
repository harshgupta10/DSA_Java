import java.util.*;
class sumOfTwoArrays{
    public static void main(String args []){
        int a []= {9,9};
        int b []= {0,0,1,0};
        int carry = 0;
        int i = a.length-1;
        int j = b.length-1;
        int k = i>j?i:j + 1;
       int sum[] = new int[k+1];
        while(i>=0|| j>=0 || k>=0){
            int add = carry;
            if(i>=0)
              add+=a[i];
            if(j>=0)
              add+=b[j];

            carry = add/10;
            add = add%10;
            sum[k]= add;

            i--;
            j--;
            k--;    
        }
        int index = 0 ;
        for(int l = 0; l<sum.length;l++){
            if(sum[l]!=0){
                index = l;
                break;
            }
        }    
        for(int m = index; m<sum.length;m++)
              System.out.print(sum[m]+" ");
        
    }
}