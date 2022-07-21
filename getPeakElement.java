public class getPeakElement {
    public int peakElement(int[] arr,int n)
    {
    
    int low = 0;
    int high = n-1;
    while(low<=high){
        int mid = low + (high-low)/2;
        if((mid==0 ||arr[mid-1]<=arr[mid])&&(mid==n-1 || arr[mid]>=arr[mid+1]))
           return mid;
         else if(mid>0 && arr[mid]<=arr[mid-1])
             high = mid-1;
         else low = mid + 1;     
      }
      return -1;
    }

    public static void main(String args []){
        int arr[]={4,2,1,6};
        int n = 4;
        getPeakElement g = new getPeakElement();
        System.out.println(g.peakElement(arr,n));
    }
}
