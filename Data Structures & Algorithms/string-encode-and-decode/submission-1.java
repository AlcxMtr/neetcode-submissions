class Solution {

    public String encode(List<String> strs) {
        int numStrings = strs.size();
        char c = (char) numStrings;
        StringBuilder encoded = new StringBuilder();
        encoded.append(c);
        StringBuilder concat = new StringBuilder();
        for (String str : strs) {
            encoded.append((char) str.length());
            concat.append(str);
        }
        encoded.append(concat.toString());
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        if (str.length() <= 0) return list;
        int numWords = str.charAt(0);
        for (int i = 1, j = i+numWords; i <= numWords; i++) {
            int wordLen = (int) str.charAt(i);
            String word = str.substring(j, j + wordLen);
            list.add(word);
            j += wordLen;
        }
        return list;
    }
}
