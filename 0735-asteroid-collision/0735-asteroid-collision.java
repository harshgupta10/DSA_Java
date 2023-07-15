class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
        if(asteroids[i]>0||stack.empty())stack.push(asteroids[i]);
            else{
                while(!stack.empty() && stack.peek()>0 && Math.abs(asteroids[i])>stack.peek()){
                    stack.pop();
                }
                if(!stack.empty() && stack.peek()==Math.abs(asteroids[i]))
                    stack.pop();
                else if(stack.empty() || stack.peek()<0)
                    stack.push(asteroids[i]);
            }
        }
        int arr[]=new int[stack.size()];
        for(int i=arr.length-1;i>=0;i--){
            arr[i]=stack.pop();
        }
        return arr;
    }
}