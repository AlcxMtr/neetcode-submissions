class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            if (!mp.containsKey(num)) {
                int lowerSeq = mp.getOrDefault(num - 1, 0);
                int higherSeq = mp.getOrDefault(num + 1, 0);
                int currentLength = lowerSeq + higherSeq + 1;
                mp.put(num, currentLength);
                mp.put(num - lowerSeq, currentLength);
                mp.put(num + higherSeq, currentLength);
                res = Math.max(res, currentLength);
            }
        }
        return res;
    }
}
