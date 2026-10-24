class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            if (!mp.containsKey(num)) {
                int lowerSeq = mp.getOrDefault(num - 1, 0);
                int higherSeq = mp.getOrDefault(num + 1, 0);
                mp.put(num, lowerSeq + higherSeq + 1);
                mp.put(num - lowerSeq, mp.get(num));
                mp.put(num + higherSeq, mp.get(num));
                res = Math.max(res, mp.get(num));
            }
        }
        return res;
    }
}
