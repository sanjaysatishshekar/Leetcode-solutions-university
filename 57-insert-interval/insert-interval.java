class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        int[] temp = newInterval;
        for (int[] interval: intervals) {
            if (interval[0] > temp[1] || interval[1] < temp[0]) {
                if (temp[0] < interval[0]) {
                    result.add(temp);
                    temp = interval;
                }
                else {
                    result.add(interval);
                }
            }
            else {
                temp[0] = Math.min(temp[0], interval[0]);
                temp[1] = Math.max(temp[1], interval[1]);
            }
        }
        result.add(temp);
        return result.toArray(new int[result.size()][2]);
    }
}