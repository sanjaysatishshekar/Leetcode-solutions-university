class Solution {
    public int maxDistance(String moves) {
        int[] table = new int[128];
        for (char move: moves.toCharArray()) {
            table[move]++;
        }
        return Math.abs(table['L'] - table['R']) + Math.abs(table['U'] - table['D']) + table['_'];
        // int underscore = 0;
        // int[] current = {0, 0};
        // int[][] table = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        // for (char move: moves.toCharArray()) {
        //     if (move == 'L') {
        //         current[0] += table[0][0];
        //         current[1] += table[0][1];
        //     }
        //     else if (move == 'U') {
        //         current[0] += table[1][0];
        //         current[1] += table[1][1];
        //     }
        //     else if (move == 'R') {
        //         current[0] += table[2][0];
        //         current[1] += table[2][1];
        //     }
        //     else if (move == 'D') {
        //         current[0] += table[3][0];
        //         current[1] += table[3][1];
        //     }
        //     else {
        //         underscore++;
        //     }
        // }
        // return Math.abs(current[0]) + Math.abs(current[1]) + underscore;
    }
}