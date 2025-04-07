class Solution {
    public  int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
       
        for (String token : tokens) {
            if (!checkSymbol(token)) {
                stack.push(Integer.parseInt(token));
            }
            else {
                int b = stack.pop(), a = stack.pop();
                stack.push(operate(a,b,token));
                
            }
        }
        
        return stack.pop();
    }
    public int operate(int a, int b, String op) {
        switch (op) {
            case "+":
                return (a + b);
            case "-":
                return (a - b);
            case "*":
                return (a * b);
            case "/":
                return (a / b);
        }
        return 0;
    }

    public  boolean checkSymbol(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}