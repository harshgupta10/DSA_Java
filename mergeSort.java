import java.util.Arrays;

public class mergeSort {
  public static void main(String[] args) {
    int arr[]={6,4,3,8,9};
    sort(arr,0,arr.length-1);
    System.out.println(Arrays.toString(arr));
  }  
   
  public static void sort(int arr[],int start,int end){
    if(end-start == 1) return;
    int mid= (start+end)/2;

    sort(arr,start,mid);
    sort(arr,mid,end);

    merge(arr,start,mid,end);
  }

  public static void merge(int arr[],int start,int mid,int end){
    int temp[] = new int[end-start];
    int i=start;
    int j=mid;
    int k=0;

    while(i<mid && j<end){
        if(arr[i]<arr[j]){
            temp[k]=arr[i];
            i++;
        }
        else{
            temp[k]=arr[j];
            j++;
        }
        k++;
    }
    while(i<mid){
        temp[k]=arr[i];
        i++;
        k++;
    }

    while(j<end){
        temp[k]=arr[j];
        j++;
        k++;
    }

    for(int m=0;m<temp.length;m++){
        arr[start+m]=temp[m];
    }
  }

}
