class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> letters = new HashMap<>();
        int len_s = s.length();
        int len_t = t.length();
        if (len_s != len_t) return false;
        for (int i = 0; i < len_s; i++) {
            char c = s.charAt(i);
            letters.put(c, letters.getOrDefault(c, 0)+1);
        }
        for (int i = 0; i < len_t; i++) {
            char c = t.charAt(i);
            if (letters.containsKey(c)) {
                letters.put(c, letters.get(c)-1);
            } else {
                return false;
            }
        }
        for (int i : letters.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
