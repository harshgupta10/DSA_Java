class Solution {
    int mod = (int)1e9+7;

    private long numOfWaysHelp(List<Integer> nums, List<List<Integer>> pascal ) {
        if(nums.size() <= 2) return 1;

        List<Integer> leftSubtree = new ArrayList<>(), rightSubtree = new ArrayList<>();
        int n = nums.size();
        for(int i=1; i<n; i++){
            if( nums.get(i) < nums.get(0) ) leftSubtree.add(nums.get(i));
            else rightSubtree.add(nums.get(i));
        }

        long leftWays = numOfWaysHelp(leftSubtree, pascal), rightWays = numOfWaysHelp(rightSubtree, pascal);
        int leftLen = leftSubtree.size(), rightLen = rightSubtree.size();
        return (pascal.get(n-1).get(leftLen) * ((leftWays * rightWays)%mod))%mod;
    }

    public int numOfWays(int[] nums) {
        // calculate pascal triangle for calculating nCr in O(1)
        int n = nums.length;
        List<List<Integer>> pascal = new ArrayList<>();

        for(int i=0; i<n+1; i++){
            Integer row[] = new Integer[i+1];
            Arrays.fill(row, 1);
            pascal.add(Arrays.asList(row));
            for(int j=1; j<i; j++)
                pascal.get(i).set(j, (pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j) )%mod);
        }

        List<Integer> tmp = new ArrayList<>();
        for(int x : nums) tmp.add(x);
        return (int)numOfWaysHelp(tmp, pascal) - 1;
    }
}