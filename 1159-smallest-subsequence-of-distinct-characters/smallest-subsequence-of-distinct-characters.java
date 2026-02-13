class Solution {
    public String smallestSubsequence(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] table = new int[26];
        int[] seen = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (seen[c]++ > 0) continue;
            while (!stack.isEmpty() && stack.peek() > c && i < table[stack.peek()]) 
                seen[stack.pop()] = 0;
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i: stack) sb.append((char) ('a' + i));
        return sb.toString();
    }
}