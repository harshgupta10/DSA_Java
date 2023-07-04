class MinStack {
    ArrayList <ArrayList<Integer>> stack;
    int min = Integer.MAX_VALUE;
    int size = -1;
    public MinStack() {
        stack = new ArrayList<ArrayList<Integer>>();
    }
    
    public void push(int val) {
        ++size;
        ArrayList <Integer> arr = new ArrayList<>();
         min = size==0?val:Math.min(stack.get(size-1).get(1),val);
        arr.add(val);
        arr.add(min);
        stack.add(arr);
    }
    
    public void pop() {
        if(size>=0){
            stack.remove(size);
            --size;
        }
    }
    
    public int top() {
       return stack.get(size).get(0);
    }
    
    public int getMin() {
        return stack.get(size).get(1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */