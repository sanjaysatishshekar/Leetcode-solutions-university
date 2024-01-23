class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        int[] tempInterval = newInterval;
        for (int[] interval: intervals) {
            // if it doesn't overlap
            if (tempInterval[1] < interval[0] || 
                tempInterval[0] > interval[1]) {
                    
                // figure out which is the earlier interval
                if (tempInterval[0] < interval[0]) {
                    resultList.add(tempInterval); 
                    tempInterval = interval;
                }
                else {
                    resultList.add(interval);
                }
            }
            // if it overlaps
            else {
                tempInterval[0] = Math.min(tempInterval[0], interval[0]);
                tempInterval[1] = Math.max(tempInterval[1], interval[1]);
            }
        }
        resultList.add(tempInterval);
        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;

        
    }
}