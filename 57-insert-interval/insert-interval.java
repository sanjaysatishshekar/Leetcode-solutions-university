class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int[] temp = newInterval;
        for (int[] i: intervals) {
            // No overlap
            // if ((i[0] < temp[0] && i[1] < temp[0]) || (temp[1] < i[0] && temp[1] < i[1])) {
            if ((i[1] < temp[0]) || (temp[1] < i[0])) {
                if (i[0] > temp[1]) {
                    result.add(temp);
                    temp = i;
                }
                else {
                    result.add(i);
                }
            }
            else {
                temp[0] = Math.min(temp[0], i[0]);
                temp[1] = Math.max(temp[1], i[1]);
            }
        }
        result.add(temp);
        int[][] r = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }
}