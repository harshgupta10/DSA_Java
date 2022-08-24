public class sort {
    static void quickSort(int arr[], int low, int high){
        
        if(low<high){
        int partition_index = partition(arr,low,high);   
        quickSort(arr, low, partition_index-1);
        quickSort(arr, partition_index+1, low);
        }               
    
        }

    static int partition(int arr[],int low, int high){   
        int pivot = arr[high];
        int i=low-1;
        for(int j=low;j<=high-1;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }

    static void swap(int[] arr, int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    static void printArray(int[] arr, int size)
{
    for(int i = 0; i < size; i++)
        System.out.print(arr[i] + " ");
          
    System.out.println();
}
  

    public static void main(String args[]){
        int arr[] = {10,1,7,2,11,19};
        quickSort(arr, 0, arr.length-1);
        printArray(arr, arr.length);
        
    }
}
