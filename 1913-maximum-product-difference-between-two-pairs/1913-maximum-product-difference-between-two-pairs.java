class Solution {
    public int maxProductDifference(int[] nums) {
        int smallest1 = Integer.MAX_VALUE, smallest2 = Integer.MAX_VALUE;
        int largest1 = Integer.MIN_VALUE, largest2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num <= smallest1) {
                smallest2 = smallest1;
                smallest1 = num;
            } else if (num <= smallest2) {
                smallest2 = num;
            }

            if (num >= largest1) {
                largest2 = largest1;
                largest1 = num;
            } else if (num >= largest2) {
                largest2 = num;
            }
        }

        return (largest1 * largest2) - (smallest1 * smallest2);
    }
}
