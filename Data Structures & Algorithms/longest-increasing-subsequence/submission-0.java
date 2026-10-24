class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int max = 0;
        LinkedList<Integer> addedNums = new LinkedList<>();
        HashMap<Integer, Integer> seqAtX = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            int val = seqAtX.getOrDefault(num, 1);
            for (int added : addedNums) {
                if (num > added) {
                    val = Math.max(val, seqAtX.get(added) + 1);
                }
            }
            seqAtX.put(num, val);
            if (val > max) max = val;
            addedNums.add(num);
        }
        return max;
    }
}
