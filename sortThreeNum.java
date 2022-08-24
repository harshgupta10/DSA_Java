//sort number 0 1 2 in ascending order in an array 
// the catch is that the time complexity should be O(n)

public class sortThreeNum {
    public static void sort012(int a[], int n)
    {
        int start=0;
        int end=n-1;
        while(start<=end){
            if(a[start]==2 && a[end]!=2){
                swap(a,start,end);
                start++;
                end--;
            }
            
            if(a[start]!=2)
                start++;
            if(a[end]==2)
                end--;
        }
        
        start=0;
        while(start<=end){
            if(a[start]==1 && a[end]==0){
                swap(a,start,end);
                start++;
                end--;
            }
            
            if(a[start]==0)
                start++;
            if(a[end]==1)
                end--;
        }
    }
    
    static void swap(int arr[],int i, int j){
        int temp = arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
    
    public static void main(String args[]){
        int arr[] = {0,2,1,2,0};
        sort012(arr,arr.length);
        int i=0;
        while(i<arr.length){
            System.out.print(arr[i]+" ");
            i++;
        }
    }
}
