public class subOftwoArrays {
    public static void main(String args []){
     int x[]={2,0,8};
     int y[]={1,2,0,9};
     int a[];
     int b[];

     // finding out the greater array between the two;

     if(x.length<y.length || (x.length==y.length && x[0]<y[0]) || (x.length==y.length && x[x.length-1]<y[y.length-1])){
      a=y;
      b=x;
     }
     else{
      a=x;
      b=y;
     }

     //subtraction
         
     int i = a.length-1;
     int j = b.length -1;
     int k = i>j?i:j;
     int diff[] = new int [k+1];
     int carry =0;
     
     while(i>=0||j>=0||k>=0){
     int sub = 0;
     int a1 = j>=0? b[j]:0;
     if(a[i] + carry >= a1){
        sub = a[i] + carry - a1 ;
        carry =0;
     }
     else{
        sub = a[i] + carry +10 -a1;
        carry = -1;
     }

     diff[k] = sub;
     i--;
     j--;
     k--;

    }

    //truncating all the zeroes;

    int index = 0 ;
    for(int l = 0; l<diff.length;l++){
        if(diff[l]!=0){
            index = l;
            break;
        }
    }    
    for(int m = index; m<diff.length;m++)
          System.out.print(diff[m]);
    
}

}
