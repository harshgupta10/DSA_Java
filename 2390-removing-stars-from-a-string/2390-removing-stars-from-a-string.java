class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<Character>();
        String str="";
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='*' && stack.empty()==false)stack.pop();
            else stack.push(s.charAt(i));
        }
        while(!stack.empty()){
             str=stack.pop()+str;
        }
        return str;
    }
}