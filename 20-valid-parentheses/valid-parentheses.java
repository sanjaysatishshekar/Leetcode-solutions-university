class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (Character c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stk.add(c);
            else if (c == ')') {
                if (!stk.isEmpty() && stk.peek() == '(') 
                    stk.pop();
                else
                    return false;
            }
            else if (c == '}') {
                if (!stk.isEmpty() && stk.peek() == '{') 
                    stk.pop();
                else
                    return false;
            }
            else if (c == ']') {
                if (!stk.isEmpty() && stk.peek() == '[') 
                    stk.pop();
                else
                    return false;
            }

        }
        if (!stk.isEmpty())
            return false;
        return true;
        
    }
}