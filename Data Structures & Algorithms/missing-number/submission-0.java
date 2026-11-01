class Solution {
    public int missingNumber(int[] nums) {
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
            //swap(nums, i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                return i;
            }
        }
        return nums.length;
    }

    public void swap(int[] nums, int i) {
        int num = nums[i];
        if (nums[i] == nums.length) {
            nums[i] = -1;
            return;
        } 
        if (num != -1 && num != i) {
            nums[i] = nums[num];
            nums[num] = num;
            swap(nums, i);
        }
    }
}
