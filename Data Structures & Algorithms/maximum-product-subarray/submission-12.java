class Solution {
    public static final int MIN_VALUE = -11;
    public int maxProduct(int[] nums) {
        int max = MIN_VALUE;
        List<List<Integer>> groups = splitByZero(nums);
        System.out.println(groups);
        for (List<Integer> group : groups) {
            int groupMax = maxInGroup(group);
            if (groupMax > max) max = groupMax;
        }
        if (groups.size() > 1 && max < 0) max = 0;
        return max;
    }

    // Groups do not contain zeroes
    private int maxInGroup(List<Integer> nums) {
        int max = MIN_VALUE;
        int posProd = 0;
        boolean posSet = false;
        int negProd = 0;
        boolean negSet = false;
        for (int num : nums) {
            if (num < 0) {
                int temp;
                if (posProd == 0) {
                    temp = num;
                } else {
                    temp = posProd*num;
                }
                if (negSet) posSet = true;
                negSet = true;
                posProd = negProd*num;
                negProd = temp;
            } else {
                int temp;
                if (posProd == 0) {
                    posProd = num;
                    posSet = true;
                } else {
                    posProd *= num;
                }
                negProd *= num;
            }
            if (posProd > max && posSet) max = posProd;
            if (posProd > max && negSet) max = negProd;
        }
        return max;
    }

    private List<List<Integer>> splitByZero(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubarray = new ArrayList<>();
        result.add(currentSubarray);
        for (int element : array) {
            
            if (element == 0) {
                currentSubarray = new ArrayList<>();
                result.add(currentSubarray);
            } else {
                currentSubarray.add(element);
            }
        }
        return result;
    }
}
