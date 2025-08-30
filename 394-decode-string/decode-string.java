class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                List<Character> stringToAdd = new ArrayList<>();
                while (stack.peek() != '[') {
                    stringToAdd.add(stack.pop());
                }
                stack.pop();
                int k = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base = base * 10;
                }
                while (k != 0) {
                    for (int j = stringToAdd.size() - 1; j >= 0; j--) {
                        stack.push(stringToAdd.get(j));
                    }
                    k--;
                }
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}