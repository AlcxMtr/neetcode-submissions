class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] sol = {-1,-1};
        int[] copy = Arrays.copyOf(nums, len);
        Arrays.sort(copy);
        int i = 0;
        int j = len - 1;
        System.out.println(Arrays.toString(copy));
        while (i != j) {
            int sum = copy[i] + copy[j];
            
            System.out.println(sum);
            if (sum == target) {
                sol[0] = i;
                sol[1] = j;
                break;
            } 
            
            if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println(sol[0]);
        
        System.out.println(sol[1]);
        for (int k = 0; k < len; k++) {
            if (nums[k] == copy[i]) {
                sol[0] = k;
                break;
            }
        }
        for (int k = len-1; k >= 0; k--) {
            if (nums[k] == copy[j]) {
                sol[1] = k;
                break;
            }
        }
        if (sol[0] > sol[1]) {
            int temp = sol[1];
            sol[1] = sol[0];
            sol[0] = temp;
        }
        return sol;
    }
}
