class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int counter = 0;
        int prevEnd = intervals[0][1];
        int length = intervals.length;

        for (int i = 1; i < length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= prevEnd) {
                prevEnd = end;
            } else {
                counter++;
                if (prevEnd > end) prevEnd = end;
            }
        }
        return counter;
    }
}
