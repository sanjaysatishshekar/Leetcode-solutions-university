class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> result = new ArrayList<>();
        backtrack(0, n, k, 0, false, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int idx, int n, int k, int cost, boolean prevOne, StringBuilder current, List<String> result) {
        if  (cost > k) 
            return;
        if (idx == n) {
            result.add(current.toString());
            return;
        }
        current.append('0');
        backtrack(idx + 1, n, k, cost, false, current, result);
        current.deleteCharAt(current.length() - 1);

        if (!prevOne) {
            current.append('1');
            backtrack(idx + 1, n, k, cost + idx, true, current, result);
            current.deleteCharAt(current.length() - 1);    
        }
    }
}