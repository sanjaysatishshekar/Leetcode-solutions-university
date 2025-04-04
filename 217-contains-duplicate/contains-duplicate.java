class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> table = new HashSet<>();
        for (int num : nums) {
            if (!table.add(num))
                return true;
        }
        return false;
    }
}