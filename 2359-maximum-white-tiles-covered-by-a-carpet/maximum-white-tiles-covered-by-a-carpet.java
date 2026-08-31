import java.util.Arrays;

class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> Integer.compare(a[0], b[0]));

        int n = tiles.length;
        int right = 0;
        int covered = 0;
        int ans = 0;

        for (int left = 0; left < n; left++) {

            long carpetEnd = (long) tiles[left][0] + carpetLen - 1;

            // Add all intervals that are completely covered
            // by the carpet starting at tiles[left][0].
            while (right < n && tiles[right][1] <= carpetEnd) {
                covered += tiles[right][1] - tiles[right][0] + 1;
                right++;
            }

            // The next interval may be partially covered.
            int partial = 0;

            if (right < n && tiles[right][0] <= carpetEnd) {
                partial = (int) (carpetEnd - tiles[right][0] + 1);
            }

            ans = Math.max(ans, covered + partial);

            if (ans >= carpetLen) {
                return carpetLen;
            }

            // We're moving the carpet start from tiles[left]
            // to tiles[left + 1], so remove tiles[left]
            // if it was part of our fully covered window.
            if (left < right) {
                covered -= tiles[left][1] - tiles[left][0] + 1;
            }
        }

        return ans;
    }
}