class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> s = new HashSet<>();
        for (int num: nums) s.add(num);
        int n = nums.length + 1;
        for (int i = 1; i <= n; i++) {
            if (!s.contains(k * i)) return k * i;
        }
        return -1;
    }
}