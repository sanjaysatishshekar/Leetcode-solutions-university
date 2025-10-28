class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        for (char digit: num.toCharArray()) {
            while (s.size() > 0 && k > 0 && s.peek() > digit) {
                s.pop();
                k -= 1;
            }
            s.push(digit);
        }

        for (int i = 0; i < k; i++) {
            s.pop();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingzero = true;
        for (char digit: s) {
            if (leadingzero && digit == '0') continue;
            leadingzero = false;
            sb.append(digit);
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}