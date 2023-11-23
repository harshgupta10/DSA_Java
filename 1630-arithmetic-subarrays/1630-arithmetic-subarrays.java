class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int resultSize = l.length;
        List<Boolean> result = new ArrayList<>(resultSize);
        for (int resIndx = 0; resIndx < resultSize; resIndx++) {
            int left = l[resIndx], right = r[resIndx];
            List<Integer> rArr = new ArrayList<>();
            for (int numsIndx = left; numsIndx <= right; numsIndx++) {
                rArr.add(nums[numsIndx]);
            }
            if (isArith(rArr)) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    private boolean isArith(List<Integer> rArr) {
        Collections.sort(rArr);
        int diff = rArr.get(1) - rArr.get(0);
        for (int indx = 1; indx < rArr.size(); indx++) {
            if (diff != rArr.get(indx) - rArr.get(indx - 1)) {
                return false;
            }
        }
        return true;
    }
}