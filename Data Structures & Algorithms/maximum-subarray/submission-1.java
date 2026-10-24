class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int max = nums[0];
        // find largest number
        for (int num : nums) {
            if (num > max) max = num;
        }
        int i = 0;
        // find first positive index
        for (;i < len; i++) {
            int num = nums[i];
            if (num > 0) {
                max = num;
                break;
            }
        }
        // if none exists, leave
        if (max < 0) return max;

        int current_sum = max;
        i++;
        for (;i < len; i++) {
            int num = nums[i];
            if (num > 0) {
                current_sum += num;
            } else {
                current_sum += num;
                if (current_sum < 0) {
                    current_sum = 0;
                }
            }
            if (current_sum > max) max = current_sum;
        }
        return max;
    }
}
