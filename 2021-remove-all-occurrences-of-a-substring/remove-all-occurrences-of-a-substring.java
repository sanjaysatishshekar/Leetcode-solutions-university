class Solution {
    public String removeOccurrences(String s, String part) {
        // while (s.contains(part)) {
        //     int startIndex = s.indexOf(part);
        //     s = s.substring(0, startIndex) + s.substring(startIndex + part.length());
        // }
        // return s;

        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int m = part.length();
        for (int i = 0; i < n; i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= m && check(stack, part, m)) {
                for (int j = 0; j < m; j++)
                    stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();
        return result.toString();
    }

    private boolean check(Stack<Character> stack, String part, int l) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stack);

        for (int i = l - 1; i >= 0; i--) {
            if (temp.isEmpty() || temp.peek() != part.charAt(i)) return false;
            temp.pop();
        }
        return true;
    }
}