class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int l;
        int r;
        int len = s.length();
        if (len%2 == 0) {
            r = len/2;
            l = r - 1;
        } else {
            r = len/2 + 1;
            l = r - 2;
        }
        for (int i = 0; i < len/2; i++) {
            if (s.charAt(l) == s.charAt(r)) {
                r++;
                l--;
            } else {
                return false;
            }
        }
        return true;
    }
}
