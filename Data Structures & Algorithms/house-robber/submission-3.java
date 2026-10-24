class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] money = new int[4];

        if (len > 0) money[0] = nums[0];
        else return 0;
        
        if (len > 1) {
            money[1] = nums[1];
        } else {
            return money[0];
        }
        if (len > 2) {
            money[2] = nums[2] + nums[0];
        } else {
            return Math.max(money[0], money[1]);
        }

        for (int i = 0; i < len - 3; i++) {
            money[(3 + i)%4] = nums[i + 3] + Math.max(money[(1 + i)%4], money[(i)%4]);
        }

        System.out.println(len);
        int h1 = money[(len - 1)%4];
        int h2 = money[(len - 2)%4];
        return Math.max(h1, h2);
    }
}
