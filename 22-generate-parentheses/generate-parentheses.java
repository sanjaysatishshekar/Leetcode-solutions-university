class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(sb, 0, 0, n);
        return result;
    }

    private void backtrack(StringBuilder sb, int open, int closed, int n) {
        if (open == closed && closed == n){
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            backtrack(sb, open + 1, closed, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closed < open) {
            sb.append(')');
            backtrack(sb, open, closed + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}