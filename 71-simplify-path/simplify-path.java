class Solution {
    public String simplifyPath(String path) {
        String[] p = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s: p) {
            if (s.equals(".") || s.isEmpty()) continue;
            else if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            }
            else {
                stack.push(s);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir: stack) {
            result.append("/");
            result.append(dir);
        }
        return result.length() == 0 ? "/" : result.toString();

    }
}