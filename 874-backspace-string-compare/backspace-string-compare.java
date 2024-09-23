class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder tb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == '#') {
                // if (!stack.isEmpty())
                //     stack.pop();
                if (sb.length() > 0)
                    sb.deleteCharAt(sb.length() - 1);
            }
            else {
                // stack.push(c);
                sb.append(c);
            }
        }
        for (char c: t.toCharArray()) {
            if (c == '#') {
                // if (!stack.isEmpty())
                //     stack.pop();
                if (tb.length() > 0)
                    tb.deleteCharAt(tb.length() - 1);
            }
            else {
                // stack.push(c);
                tb.append(c);
            }
        }
        // String sa = sb.toString();
        // String ta = tb.toString();
        // System.out.println(sa + " " + ta);

        return sb.toString().equals(tb.toString());

    }
}