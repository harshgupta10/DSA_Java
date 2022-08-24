 class getMinMax{
    static class pair{
        int min;
        int max;
    }
    static pair min_max(int arr[],int low, int high){
        pair minmax = new pair();
        pair left_arr = new pair();
        pair right_arr = new pair();

            if(low==high){
            minmax.max=arr[low];
            minmax.min=arr[high];
            return minmax;
        }

        if(high == low+1){
            if(arr[low]<arr[high]){
                minmax.min=arr[low];
                minmax.max=arr[high];
            }
            else{
                minmax.max=arr[low];
                minmax.min=arr[high];
            }
            return minmax;
        }

        int mid = (high+low)/2;
        left_arr = min_max(arr,low,mid);
        right_arr =min_max(arr,mid+1,high);

        if(left_arr.min<right_arr.min){
            minmax.min= left_arr.min;
        }
        else{
            minmax.min = right_arr.min;
        }

        if(left_arr.max>right_arr.max){
            minmax.max=left_arr.max;
        }
        else{
            minmax.max = right_arr.max;
        }

        return minmax;
    }

     public static void main(String args []){
        int arr[]={5,2,22,8,19,6};
        pair minmax = min_max(arr, 0, arr.length-1);
        System.out.println("min: "+minmax.min);
        System.out.println("max: "+minmax.max);
     }

}