class Solution {
    public int[][] generateMatrix(int n) {
        List<Integer> res = new ArrayList<>();
        int[][] arr = new int[n][n];
        int b = n, r = n;
        int t = 0, l = 0, size = b*r,s=1;
        while(t<=b && l<=r){
            for (int i = l; i < r; i++) {
                arr[t][i]=s++;
            }
            t++;
            for (int i = t; i < b; i++) {
                arr[i][r-1] = s++;
            }
            r--;

            for (int i = r-1; i >= l; i--) {
                arr[b-1][i] = s++;
            }
            b--;

            for (int i = b-1; i >= t; i--) {
                arr[i][l]=s++;
            }
            l++;


        }
        return arr;

    }
}