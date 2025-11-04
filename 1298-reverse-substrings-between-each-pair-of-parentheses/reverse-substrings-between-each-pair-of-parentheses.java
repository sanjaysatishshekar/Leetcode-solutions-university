class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> open = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                open.push(sb.length());
            }
            else if (c == ')') {
                int start = open.pop();
                reverse(sb, start, sb.length() - 1);
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private void reverse(StringBuilder sb, int i, int j) {
        while (i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
    }
}