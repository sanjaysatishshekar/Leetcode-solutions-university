class Solution {
    public int[] decimalRepresentation(int n) {
        String s = String.valueOf(n);
        int prod = 1;
        List<Integer> result = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '0')
                result.add((c - '0') * prod);
            prod = prod * 10;
        }
        int[] answer = new int[result.size()];
        for (int i = result.size() - 1; i >= 0; i--) {
            answer[result.size() - i - 1] = result.get(i);
        }
        return answer;
    }
}