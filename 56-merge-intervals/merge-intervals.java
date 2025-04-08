class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // if they overlap we just expand the size of temp
            if ((temp[0] <= interval[0] && interval[0] <= temp[1]) || 
                temp[0] <= interval[1] && interval[1] <= temp[1]) {
                temp[0] = Math.min(temp[0], interval[0]);
                temp[1] = Math.max(temp[1], interval[1]);
            }
            // if they don't then we just add temp to the list
            else {
                merged.add(temp);
                temp = interval;
            }
        }
        merged.add(temp);
        int[][] result = new int[merged.size()][];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }
}