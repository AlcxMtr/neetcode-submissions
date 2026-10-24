class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        s = sb.toString();
        int maxLen = 0;
        int maxStartIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            int len = -1;
            while (s.charAt(l) == s.charAt(r)) {
                len++;
                l--;
                r++;
                if (l < 0 || r >= s.length()) break;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStartIndex = l + 1;
            }
        }
        String sub = s.substring(maxStartIndex, maxStartIndex + maxLen*2 + 1);
        return sub.replace("#", "");
    }
}
