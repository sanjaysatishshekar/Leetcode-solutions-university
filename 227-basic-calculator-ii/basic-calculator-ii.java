class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int l = s.length();
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        char op = '+';
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                current = current * 10 + (c - '0');
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == l - 1) {
                if (op == '-') stack.push(-current);
                else if (op == '+') stack.push(current);
                else if (op == '*') stack.push(stack.pop() * current);
                else if (op == '/') stack.push(stack.pop() / current);
                op = c;
                current = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty())
            result += stack.pop();
        return result;
    }
}