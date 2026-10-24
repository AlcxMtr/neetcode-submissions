class Solution {
    public int maxArea(int[] heights) {
        int len = heights.length;
        int leftIdx = 0;
        int rightIdx = len-1;
        int max = 0;
        while (leftIdx < rightIdx) {
            int leftVal = heights[leftIdx];
            int rightVal = heights[rightIdx];
            int diff = rightIdx - leftIdx;
            int volume = 0;
            if (leftVal >= rightVal) {
                volume = rightVal*diff;
                rightIdx--;
            } else {
                volume = leftVal*diff;
                leftIdx++;
            }
            if (volume > max) max = volume;
        }
        return max;
    }
}
