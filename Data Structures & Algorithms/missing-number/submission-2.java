class Solution {
    public int missingNumber(int[] nums) {
        // These two loops peform at most 2n iterations
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != -1 && nums[i] != i) {
                int num = nums[i];
                if (num == nums.length) {
                    nums[i] = -1;
                    continue;
                } 
                nums[i] = nums[num];
                nums[num] = num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                return i;
            }
        }
        return nums.length;
    }
}
