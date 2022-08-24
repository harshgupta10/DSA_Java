public class moveAllNegativeNumbers {
    public static void segregateElements(int arr[], int n)
    {
        int a[]=new int[n];
        int j =0 ;
       
       for(int i= 0;i<n;i++)
          if(arr[i]>=0)      // Put positive integers in array first;
            a[j++] = arr[i];  
    
       for(int i=0;i<n;i++)
           if(arr[i]<0)     // Put Negative integers in array;
             a[j++] = arr[i];
          
       for(int i=0;i<n;i++)
        arr[i] = a[i];     // Transform original array;
     
    }

    public static void main(String args[]){
        int arr[]={0,-2,4,-5,8,90,-10};
        segregateElements(arr,arr.length);
    
    for(int i =0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
    }

    }
}
