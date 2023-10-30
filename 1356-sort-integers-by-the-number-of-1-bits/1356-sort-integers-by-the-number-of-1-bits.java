import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> Integer.compare(Integer.bitCount(a), Integer.bitCount(b)) == 0 ? a - b : Integer.compare(Integer.bitCount(a), Integer.bitCount(b)));
        return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
    }
}