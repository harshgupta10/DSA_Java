class Solution {
    private void reverseArray(int[] arr){
        int l=0,h=arr.length-1;
        while(l<h){
            int temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
            l++;
            h--;
        }
        return;
    }

 
    private boolean recursive_approach(int a1Idx,int[] arr1,int[] arr2){
        int n=arr1.length;
        if(a1Idx==n){
            return true;
        }

       
        for(int i=0;i<arr2.length;i++){
            
            if(arr2[i]>=arr1[a1Idx]){
                arr2[i]=arr2[i]-arr1[a1Idx];
                boolean flage=recursive_approach(a1Idx+1,arr1,arr2);
                if(flage==true) return true;
                arr2[i]=arr2[i]+arr1[a1Idx];
            }
            
            
        }
        return false;
    }

   
    public boolean canDistribute(int[] nums, int[] quantity) {

        Map<Integer,Integer>mp=new HashMap<>();

       
        for(int i:nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }

        int[] frequencyArr=new int[mp.size()];
        int idx=0;
        for(var e:mp.keySet()){
            frequencyArr[idx++]=mp.get(e);
        }

        
        Arrays.sort(quantity);
        Arrays.sort(frequencyArr);
        reverseArray(quantity);


        //recursive_approach
        boolean flage=recursive_approach(0,quantity,frequencyArr);
        return flage;
    }
}