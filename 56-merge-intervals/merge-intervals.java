class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int[] temp =  intervals[0];
        for (int[] interval: intervals) {
            if ((temp[0] <= interval[0] &&  interval[0] <= temp[1])
                || (temp[0] <= interval[1] && interval[1] <= temp[1]))  {
                    temp[0] = Math.min(temp[0], interval[0]);
                    temp[1] = Math.max(temp[1], interval[1]);
            }
            else {
                merged.add(temp);
                temp = interval;
            }
        }
        merged.add(temp);
        int[][] answer = new int[merged.size()][];
        for (int i = 0; i < merged.size(); i++) {
            answer[i] = merged.get(i);
        }
        return answer;
    }
}