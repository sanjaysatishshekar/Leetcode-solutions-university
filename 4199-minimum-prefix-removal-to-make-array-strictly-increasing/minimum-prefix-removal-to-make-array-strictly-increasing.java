class Solution {
    public int minimumPrefixLength(int[] nums) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(nums[i]);
                continue;
            }
            else {
                if (stack.peek() <= nums[i]) {
                    return i + 1;
                }
                else {
                    stack.push(nums[i]);
                }
            }
        }
        return 0;
    }
}