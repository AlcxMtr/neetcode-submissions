class WordDictionary {
    // OK MISTAKE: I thought that by "any string", we included substrings...
    class WordSpot {
        char[] chars;
        int length;
        int cur_idx;
        public WordSpot(char[] arr, int len, int idx) {
            chars = arr;
            length = len;
            cur_idx = idx;
        }
    }
    ArrayList<WordSpot>[] struct = new ArrayList[26];

    private int charIdx(char c) {
        return c - 97;
    }

    public WordDictionary() {
        for (int i = 0; i < 26; i++) {
            struct[i] = new ArrayList<>();
        }
    }

    public void addWord(String word) {
        char[] charArr = word.toCharArray();
        int len = charArr.length;
        for (int i = 0; i < len; i++) {
            char c = charArr[i];
            int charIdx = charIdx(c);
            ArrayList<WordSpot> list = struct[charIdx];
            list.add(new WordSpot(charArr, len, i));
        }
    }

    public boolean search(String word) {
        char[] charArr = word.toCharArray();
        int len = charArr.length;
        if (len == 0) return true;

        int start_idx = 0;
        if (charArr[0] != '.') {
            start_idx = 0;
        } else if (len >= 2 && charArr[1] != '.') {
            start_idx = 1;
        } else if (len >= 3) {
            start_idx = 2;
        } else {
            return false;
        }

        char c = charArr[start_idx];
        int charIdx = charIdx(c);
        ArrayList<WordSpot> list = struct[charIdx];
        for (WordSpot spot : list) {
            if (checkWordSpot(spot, charArr, start_idx)) return true;
        }
        return false;
    }

    private boolean checkWordSpot(WordSpot spot, char[] word, int start_idx) {
        int wordLen = word.length;
        if (spot.length != wordLen) return false;
        if (spot.length - spot.cur_idx < wordLen - start_idx) return false;
        if (spot.cur_idx < start_idx) return false;
        for (int i = start_idx; i < wordLen; i++) {
            if (word[i] == '.') continue;
            if (spot.chars[i + spot.cur_idx - start_idx] != word[i]) return false;
        }
        return true;
    }


}
