class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int index = 0;
        for (char c: instructions.toCharArray()) {
            if (c == 'L')
                index = (index + 3) % 4;
            else if (c == 'R')
                index = (index + 1) % 4;
            else {
                x += direction[index][0];
                y += direction[index][1];
            }
        }
        return (x == 0 && y == 0) || index != 0;
        
    }
}