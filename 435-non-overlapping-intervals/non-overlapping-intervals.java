class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // Check if they're not overlapping
            if (prevEnd <= interval[0]) {
                prevEnd = interval[1];
            } else {
                count++;
                prevEnd = Math.min(prevEnd, interval[1]);
            }
        }
        return count;
    }
}