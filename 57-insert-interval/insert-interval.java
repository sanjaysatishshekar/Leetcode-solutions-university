class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int[] temp = newInterval;
        for (int[] interval: intervals) {
            // if they don't intersect
            if (interval[0] > temp[1] || interval[1] < temp[0]) {
                // figure out which is earlier
                // add them to the list
                if (temp[0] < interval[0]) {
                    result.add(temp);
                    temp = interval;
                }
                else {
                    result.add(interval);
                }
            }
            // if overlapping figure out the bigger interval
            else {
                temp[0] = Math.min(temp[0], interval[0]);
                temp[1] = Math.max(temp[1], interval[1]);
            }
        }
        result.add(temp);
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}