class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        int n = nums.length;
        long[] stack = new long[n];
        int top = -1;

        for (int num: nums) {
            long current = num;
            while (top >= 0 && stack[top] == current) {
                current += stack[top];
                top--;
            }
            stack[top + 1] = current;
            top++;
        }

        List<Long> result = new ArrayList<>(top + 1);
        for (int i = 0; i <= top; i++) {
            result.add(stack[i]);
        }
        return result;
    } 
}