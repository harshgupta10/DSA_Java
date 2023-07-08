class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack <Integer> stack = new Stack<>();
        int result[] = new int[n];
       for(int i=0;i<n;i++)result[i]=prices[i];
        for(int i=0;i<n;i++){
            while(!stack.empty() && prices[i]<=prices[stack.peek()]){
                int top = stack.pop();
                result[top]=prices[top]-prices[i];
            }
            stack.push(i);
        }
        return result;
    }
}