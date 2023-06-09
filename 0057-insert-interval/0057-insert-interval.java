class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            if (newInterval[1] < intervals[i][0]) {
                output.add(newInterval);
                while (i < intervals.length) {
                    output.add(intervals[i]);
                    i++;
                }
                return output.toArray(new int[output.size()][]);
            } else if (newInterval[0] > intervals[i][1]) {
                output.add(intervals[i]);
                i++;
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
        }
        output.add(newInterval);
        return output.toArray(new int[output.size()][]);
    }
}