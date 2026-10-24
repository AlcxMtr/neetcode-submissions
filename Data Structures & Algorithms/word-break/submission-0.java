class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        int numWords = wordDict.size();
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            if (dp[i] != true) continue;
            for (String word : wordDict) {
                int wordLen = word.length();
                if (s.startsWith(word, i) /*&& i+wordLen < len+1*/) {
                    dp[i+wordLen] = true;
                }
            }
        }
        return dp[len];
    }
}
