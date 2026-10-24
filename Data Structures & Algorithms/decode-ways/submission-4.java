class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int paired = 0;
        int single = 1;
        if (len >= 1 && s.charAt(0) == '0') return 0;
        if (len == 1) return 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '0') {
                if (Character.getNumericValue(s.charAt(i-1)) >= 3) return 0;
                paired = single;
                single = 0;
                continue;
            }
            int last_paired = paired;
            paired = 0;
            if (Integer.parseInt((s.substring(i-1,i+1))) <= 26) {
                paired = single;
            }
            single = single + last_paired;
        }
        return paired + single;
    }
}
