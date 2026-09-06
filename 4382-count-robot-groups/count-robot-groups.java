class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int result = 0, n = speed.length, p2 = Integer.MAX_VALUE, s2 = p2;
        for (int i = n - 1; i > - 1; i--) {
            int p = position[i], s = speed[i];
            if (p2 - p > distance && s <= s2) {
                result++;
                s2 = s;
            }
            p2 = p;
        }
        return result;
    }
}