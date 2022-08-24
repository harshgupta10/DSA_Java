//  https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
// brute force approach

public class getKthLargestelement {
    public static int findKthLargest(int[] arr, int k) {
        int length = arr.length;
        int max =Integer.MIN_VALUE;
        int index = -1;
        for(int j=0;j<k;j++){
        for(int i=j;i<length;i++){
            if(arr[i]>max){
                max=arr[i]; 
                index=i;
            }
        }
           int temp = arr[j];
            arr[j]=arr[index]; 
            arr[index]=temp;
            index = -1;
            max = Integer.MIN_VALUE;
        }
        
        
        return arr[k-1];
    }

    public static void main(String args []){
        int arr[]={3,2,3,1,2,4,5,5,6};
        int k = 4;

        System.out.println(findKthLargest(arr,k));
    }
}
