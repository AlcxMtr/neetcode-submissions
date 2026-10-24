class Solution {
    public int countSubstrings(String s) {
        int totalNum = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            while (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                totalNum++;
                if (l < 0 || r >= s.length()) break;
            }
            l = i;
            r = i + 1;
            if (r >= s.length()) continue;
            while (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                totalNum++;
                if (l < 0 || r >= s.length()) break;
            }
        }
        return totalNum;
    }
}
