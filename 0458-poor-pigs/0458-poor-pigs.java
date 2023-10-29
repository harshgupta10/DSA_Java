class Solution {
     public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int testsPerPig = minutesToTest / minutesToDie + 1;
        
        while (Math.pow(testsPerPig, pigs) < buckets) {
            pigs++;
        }
        
        return pigs;
    }
}