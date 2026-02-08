class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> a = new ArrayList<>();
        Stack<Long> stack = new Stack<>();
        for (int num: nums) {
            if (stack.isEmpty()) {
                stack.push((long) num);
                continue;
            }
            long res = num;
            while (!stack.isEmpty() && stack.peek() == res) {
                res = (long) (stack.pop() + res);
            }
            stack.push(res);
        }
        while (!stack.isEmpty()) {
            a.add(stack.pop());
        }
        Collections.reverse(a);
        return a;
    } 
}