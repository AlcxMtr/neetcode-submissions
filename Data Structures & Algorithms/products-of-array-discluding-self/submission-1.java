class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        int product = 1;
        int num_zeroes = 0;
        for (int num : nums) product *= num;
        left[0] = nums[0];
        for (int i = 1; i < len; i++) left[i] = left[i-1] * nums[i];
        right[len-1] = nums[len-1];
        for (int i = len - 2; i >= 0; i--) right[i] = right[i+1] * nums[i];
        output[0] = right[1];
        output[len-1] = left[len-2];
        for (int i = 1; i < len - 1; i++) {
            output[i] = left[i-1]*right[i+1];
        }
        return output;
    }
}  
