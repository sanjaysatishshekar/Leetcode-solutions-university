class Solution {
    static class Fenwick {
        long[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new long[n + 2];
        }

        void update(int idx, long val) {
            while (idx <= n) {
                tree[idx] = Math.max(tree[idx], val);
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            long res = 0;
            while (idx > 0) {
                res = Math.max(res, tree[idx]);
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public long maxAlternatingSum(int[] nums, int k) {
        int n = nums.length;

        // Coordinate Compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, r++);
            }
        }

        int size = r;

        Fenwick bitDown = new Fenwick(size);
        Fenwick bitUpReverse = new Fenwick(size);

        long[] up = new long[n];
        long[] down = new long[n];

        long ans = 0;

        for (int i = 0; i < n; i++) {

            // Add index i-k into Fenwick (becomes eligible)
            if (i - k >= 0) {
                int prevVal = nums[i - k];
                int prevRank = rank.get(prevVal);

                bitDown.update(prevRank, down[i - k]);

                // Reverse rank for querying greater values
                int revRank = size - prevRank + 1;
                bitUpReverse.update(revRank, up[i - k]);
            }

            int currRank = rank.get(nums[i]);

            // nums[j] < nums[i]
            long bestDown = bitDown.query(currRank - 1);

            // nums[j] > nums[i]
            int revCurr = size - currRank + 1;
            long bestUp = bitUpReverse.query(revCurr - 1);

            up[i] = nums[i];
            down[i] = nums[i];

            if (bestDown > 0) {
                up[i] = Math.max(up[i], bestDown + nums[i]);
            }

            if (bestUp > 0) {
                down[i] = Math.max(down[i], bestUp + nums[i]);
            }

            ans = Math.max(ans, Math.max(up[i], down[i]));
        }

        return ans;
    }
}