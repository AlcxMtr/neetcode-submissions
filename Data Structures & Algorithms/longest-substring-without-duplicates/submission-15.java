class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> letters = new HashMap<>(50);
        int max_length = 0;
        int repeated_index = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (letters.containsKey(c)) {
                int c_index = letters.get(c);
                if (repeated_index < c_index) repeated_index = c_index;
            }
            letters.put(c, i);
            int current_length = i - repeated_index;
            if (current_length > max_length) {
                max_length = current_length;
            }
        }
        return max_length;
    }
}
