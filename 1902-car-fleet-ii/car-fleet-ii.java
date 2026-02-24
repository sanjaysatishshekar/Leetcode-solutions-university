class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        Stack<Integer> stack = new Stack<>();
        double[] result = new double[n];
        for (int i = n - 1; i > -1; i--) {
            result[i] = -1.0;
            int p = cars[i][0], s = cars[i][1];
            while (!stack.isEmpty()) {
                int j = stack.peek();
                int p2 = cars[j][0], s2 = cars[j][1];
                if (s <= s2 || 1.0 *(p2 - p) / (s - s2) >= result[j] && result[j] > 0)
                    stack.pop();
                else
                    break; 
            }
            if (!stack.isEmpty()) {
                int j = stack.peek(), p2 = cars[j][0], s2 = cars[j][1];
                result[i] = 1.0 * (p2 - p) / (s - s2);
            }
            stack.push(i);
        }
        return result;
    }
}