class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> table = new HashMap<>();
        for (int num: nums) {
            table.put(num, table.getOrDefault(num, 0) + 1);
        }
        for (int num: nums) {
            if (table.get(num) == 1)
                return num;
        }
        return -1;
    }
}