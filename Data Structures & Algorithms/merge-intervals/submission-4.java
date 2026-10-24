class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        int length = intervals.length;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        for (int i = 0; i < length; i++) {
            int[] cur = intervals[i];
            int[] interval = new int[2];
            interval[0] = cur[0];
            interval[1] = cur[1];
            while(i+1 < length && interval[1] >= intervals[i+1][0]) {
                if (interval[1] < intervals[i+1][1]) {
                    interval[1] = intervals[i+1][1];
                }
                i++;
            }
            list.add(interval);
        }
        return list.toArray(new int[0][0]);
    }
}
