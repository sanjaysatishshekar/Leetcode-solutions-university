class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, int open, int closed, int n) {
        if (open == closed && closed == n) {
            String s = new String(sb);
            result.add(s);
            return;
        }
        if (open < n) {
            sb.append('(');
            backtrack(result, sb, open + 1, closed, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (closed < open) {
            sb.append(')');
            backtrack(result, sb, open, closed + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}