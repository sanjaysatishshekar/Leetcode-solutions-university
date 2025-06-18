class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int num: asteroids) {
            boolean flag = true;
            while (!stack.isEmpty() && (stack.peek() > 0 && num < 0)) {
                if (Math.abs(stack.peek()) < Math.abs(num)) {
                    stack.pop();
                    continue;
                }

                else if (Math.abs(stack.peek()) == Math.abs(num))
                    stack.pop();
                
                flag = false;
                break;
            }
            if (flag)
                stack.push(num);

        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i > -1; i--) {
            result[i] = stack.peek();
            stack.pop();
        }
        return result;
    }
}