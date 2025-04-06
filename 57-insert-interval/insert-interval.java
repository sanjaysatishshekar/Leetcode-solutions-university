class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0)
            return new int[][] { newInterval };

        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        result.add(newInterval);
        while (i < intervals.length) {
            int[] prev = result.get(result.size() - 1);
            if (intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(intervals[i][1], prev[1]);
                prev[0] = Math.min(intervals[i][0], prev[0]);
            } else {
                result.add(intervals[i]);
            }
            i++;
        }
        int[][] ans = new int[result.size()][2];
        for (int j = 0; j < ans.length; j++) {
            ans[j] = result.get(j);
        }
        return ans;
    }
}