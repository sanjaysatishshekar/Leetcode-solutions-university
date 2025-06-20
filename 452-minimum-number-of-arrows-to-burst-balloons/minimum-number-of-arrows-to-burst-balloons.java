class Solution {
    public int findMinArrowShots(int[][] points) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(points, (a,b) -> a[0] - b[0]);
        int[] temp = points[0];
        for (int[] point: points) {
            if ((point[0] >= temp[0] && point[0] <= temp[1])
            || (point[1] >= temp[0] && point[1] <= temp[1])) {
                temp[0] = Math.max(temp[0], point[0]);
                temp[1] = Math.min(temp[1], point[1]);
            }
            else {
                result.add(temp);
                temp = point;
            }
        }
        result.add(temp);
        return result.size();       
    }
}