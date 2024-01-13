class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int N = words.length;
        int idx = 0;
        List<String> result = new ArrayList<>();
        while(idx < N) {
            List<String> wordsInLine = getWordsForLine(idx, words, maxWidth, N);
            idx+=wordsInLine.size();
            String justifiedLine = justifyLine(wordsInLine, idx, maxWidth, N);
            result.add(justifiedLine);
        }
        return result;
    }

    private List<String> getWordsForLine(int idx, String[] words, int maxWidth, int N) {
        List<String> lineWords = new ArrayList<>();
        int lineLen = 0;
        for(int i = idx; i < N; i++) {
            if(words[i].length() + lineLen <= maxWidth) {
                lineWords.add(words[i]);
                lineLen+=words[i].length() + 1;//1 for extra space
            } else{
                break;
            }
        }
        return lineWords;
    }

    private String justifyLine(List<String> wordsInLine, int idx, int maxWidth, int N) {
        int W = wordsInLine.size();
        int extraSpaces = maxWidth - (W - 1//Spaces b/w words
        + wordsInLine.stream().mapToInt(String::length).sum());//Words Lengths

        if(wordsInLine.size() == 1 || idx == N) {
            return String.join(" ", wordsInLine) + " ".repeat(extraSpaces);
        }
        

        int extraSpacesDistributedEvenly = extraSpaces/(W-1);
        //Add evenly distributed extra spaces after each word except the last
        for(int i = 0; i < W-1; i++) {
            wordsInLine.set(i, wordsInLine.get(i) + " ".repeat(extraSpacesDistributedEvenly));
        }
        //Greedily add leftover spaces towards the left most words
        int extraSpacesLeft = extraSpaces%(W-1);
        for(int i = 0; i < extraSpacesLeft; i++) {
            wordsInLine.set(i, wordsInLine.get(i) + " ");
        }
        return String.join(" ", wordsInLine);
    }
}