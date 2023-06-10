class missingNumber{
   static int MissingNumber(int array[], int n) {
        int sum = (n*(n+1))/2;
        int sum_arr = 0;
        
       for(int i=0;i<n-1;i++){
            sum_arr+=array[i];
        }
        return sum-sum_arr;
    }

    public static void main(String args[]){
        int arr[] ={1,2,3,5};
        System.out.println(MissingNumber(arr,5));
    }
}
