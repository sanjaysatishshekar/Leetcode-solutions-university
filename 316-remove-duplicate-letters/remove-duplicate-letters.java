class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        HashMap<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++) {
            last.put(s.charAt(i), i);
        }

        HashSet<Character> seen = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {

                while (!stack.isEmpty() && c < stack.peek() && last.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c: stack) sb.append(c);
        return sb.toString();
    }
}