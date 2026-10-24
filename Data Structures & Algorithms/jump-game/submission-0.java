class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int current_max = 0;

        // boolean[] validity = new boolean[len];
        // validity[0] = true; // Start at 1
        for (int i = 0; i < len; i++) {
            if (i <= current_max) {
                current_max = Math.max(current_max, i + nums[i]);
            } else {
                break;
            }
        }

        if (current_max >= len - 1) {
            return true;
        } else {
            return false;
        }
    }
}
