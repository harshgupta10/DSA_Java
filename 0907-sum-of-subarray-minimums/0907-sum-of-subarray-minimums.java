class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod=1000000007;
        int len=arr.length;
        
        int leftMin[]=new int[len];
        Arrays.fill(leftMin,-1);
        int rightMin[]=new int[len];
        Arrays.fill(rightMin,len);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<len;i++){
            while(!stack.empty() && arr[stack.peek()]>=arr[i]){
                int index=stack.pop();
                rightMin[index]=i;
            }
            stack.push(i);
        }
        stack.clear();
        
        for(int i=len-1;i>=0;i--){
            while(!stack.empty() && arr[stack.peek()]>arr[i]){
                int index=stack.pop();
                leftMin[index]=i;
            }
            stack.push(i);
        }
        stack.clear();
        
        long res=0;
        for(int i=0;i<len;i++){
            int leftLen = i-leftMin[i];
            int rightLen = rightMin[i]-i;
            
            res=(res+((long)arr[i]*leftLen*rightLen)%mod)%mod;
        }
        return (int)res;
    }
}