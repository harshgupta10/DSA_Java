class Solution {
    public int numberOfBeams(String[] bank) {
        
        int[] devicesPerRow = new int[bank.length];
        for (int i = 0; i < bank.length; i++) {
            int deviceCount = 0;
            for (char c : bank[i].toCharArray()) {
                if (c == '1') {
                    deviceCount++;
                }
            }
            devicesPerRow[i] = deviceCount;
        }

        int totalBeams = 0;
        int i = 0; 
        int j = 1;
        while (j < bank.length) {
            
            while (j < bank.length - 1 && devicesPerRow[j] == 0) {
                j++;
            }

            totalBeams += devicesPerRow[i] * devicesPerRow[j];

            i = j;
            j++;
        }

        return totalBeams;
    }
}