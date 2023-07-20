class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<num.length();i++){
            char c = num.charAt(i);
            while(!stack.empty()&& k>0 && stack.peek()>c){
                stack.pop();
                k--;
            }
            stack.push(c);

        }
        while(k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        sb.append(stack.pop());
        
        while(sb.length() > 1 && sb.charAt(sb.length()-1) == '0')
            sb.deleteCharAt(sb.length()-1);

        return sb.isEmpty()?"0":sb.reverse().toString();    
    }
}