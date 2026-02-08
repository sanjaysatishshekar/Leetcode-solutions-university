class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> a = new ArrayList<>();
        Stack<Long> stack = new Stack<>();
        for (int num: nums) {
            if (stack.isEmpty()) {
                stack.push((long) num);
                continue;
            }
            if (stack.peek() == num) {
                long i = stack.pop();
                long res = (long)(i + num);
                while (!stack.isEmpty() && stack.peek() == res) {
                    res = res + stack.pop();
                }
                stack.push(res);
            }
            else {
                stack.push((long)num);
            }
        }
        while (!stack.isEmpty()) {
            a.add(stack.pop());
        }
        Collections.reverse(a);
        return a;
    } 
}