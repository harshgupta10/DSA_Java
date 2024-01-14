class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        if (word1.equals(word2)) return true;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (char c : word1.toCharArray()) {
            arr1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            if (arr1[c - 'a'] == 0) return false;
            arr2[c - 'a']++;
        }

        for (int n : arr1) {
            if (n != 0) {
                int index = -1;
                for (int i = 0; i < 26; i++) {
                    if (arr2[i] == n) {
                        index = i;
                        break;
                    }
                }
                if (index == -1) return false;
                arr2[index] = 0;
            }
        }

        return true;
    }
}