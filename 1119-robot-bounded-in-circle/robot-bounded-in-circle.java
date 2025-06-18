class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int d = 0;
        int[] current = { 0, 0 };

        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                current[0] += directions[d][0];
                current[1] += directions[d][1];

            } else if (c == 'R') {
                d = (d + 1) % 4;
            } else {
                d = d - 1;
                if (d == -1)
                    d = 3;
            }
        }
        if (current[0] == 0 && current[1] == 0 || d != 0)
            return true;
        return false;
    }
}