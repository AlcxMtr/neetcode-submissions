class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int product = 1;
        int num_zeroes = 0;
        for (int num : nums) {
            if (num == 0) {
                num_zeroes++;
            } else {
                product *= num;
            }
        }
        if (num_zeroes >= 2) return output;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                output[i] = product;
            } else if (num_zeroes == 1) {
                output[i] = 0;
            } else {
                output[i] = product/nums[i];
            }
        }
        return output;
    }
}  
