class Solution {
    public int characterReplacement(String s, int k) {
        int[] count=new int[26];
        int res=0 ,maxCount=0,l=0;
        for(int r=0;r< s.length(); r++){
            
            maxCount= Math.max(maxCount, ++count[s.charAt(r)-'A']);
            
            while((r-l+1) - maxCount > k){
                
                count[s.charAt(l)-'A']--;
                l++;
                
            }
            
            res= Math.max(res, r-l+1);
        }
        
        return res;
    }
}