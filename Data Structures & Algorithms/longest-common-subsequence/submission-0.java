class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (char c : text1.toCharArray()) set1.add(c);
        for (char c : text2.toCharArray()) set2.add(c);
        StringBuilder sb1 = new StringBuilder();
        for (char c : text1.toCharArray()) {
            if (set2.contains(c)) sb1.append(c);
        }
        StringBuilder sb2 = new StringBuilder();
        for (char c : text2.toCharArray()) {
            if (set1.contains(c)) sb2.append(c);
        }
        text1 = sb1.toString();
        text2 = sb2.toString();

        int len1 = text1.length();
        int len2 = text2.length();

        HashMap<Character, LinkedList<Integer>> map = new HashMap<>();

        for (int i = 0; i < len2; i++) {
            char c1 = text2.charAt(i);
            if (map.containsKey(c1)) continue;
            for (int j = 0; j < len1; j++) {
                char c2 = text1.charAt(j);
                if (c1 == c2) {
                    LinkedList list = map.getOrDefault(c1, new LinkedList<Integer>());
                    list.add(j);
                    map.put(c1, list);
                }
            }
        }
        for (char c : map.keySet()) {
            LinkedList<Integer> list = map.get(c);
            System.out.print(c + ": " + list);
            System.out.println();
        }
        System.out.println("------");
        int[] dp = new int[len1+1];
        for (int i = len2-1; i >= 0; i--) {
            char c = text2.charAt(i);
            LinkedList<Integer> list = map.get(c);
            for (int j : list) {
                int highest_sqc = dp[j+1] + 1;
                while (j >= 0) {
                    if (dp[j] < highest_sqc) {
                        dp[j] = highest_sqc;
                        j--;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(c + ": " + Arrays.toString(dp));
        }

        return dp[0];
    }
}
