class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        int a = 1, b = 1;
        for (String s: tokens) {
            if (s.equals("+")) {
                a = stk.pop();
                b = stk.pop();
                stk.push(a + b);
            }
            else if (s.equals("-")) {
                a = stk.pop();
                b = stk.pop();
                stk.push(b - a);
            }
            else if (s.equals("*")) {
                a = stk.pop();
                b = stk.pop();
                stk.push(a * b);
            }
            else if (s.equals("/")) {
                a = stk.pop();
                b = stk.pop();
                stk.push(b/a);
            }
            else {
                stk.push(Integer.parseInt(s));
            }
        }
        return stk.pop();
    }
}