class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {

        Map<Character, Integer> firstOccur = new HashMap<>();
        int ans = -1;

        for(int i = 0; i < s.length(); i++) {

            if(firstOccur.containsKey(s.charAt(i))) {
                ans = Math.max(ans, i - firstOccur.get(s.charAt(i)) - 1);
            }
            else {
                firstOccur.put(s.charAt(i), i);
            }
        }
        return ans;   
    }
}