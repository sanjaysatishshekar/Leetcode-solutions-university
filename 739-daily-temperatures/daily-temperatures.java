class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // brute force
        /*
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
        */

        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> d = new Stack<>();
        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!d.isEmpty() && temperatures[d.peek()] < temp) {
                int prevDay = d.pop();
                result[prevDay] = i - prevDay;
            }
            d.push(i);
        }
        return result;
    }
}