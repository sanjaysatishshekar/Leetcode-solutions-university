class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String sample = "123456789";
        int n = 10;
        List<Integer> result = new ArrayList<>();
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for (int len = lowLen; len <= highLen; len++) {
            for (int start = 0; start < n - len; start++) {
                int num = Integer.parseInt(sample.substring(start, start + len));
                if (low <= num && num <= high) result.add(num);
            }
        }
        return result;
    }
}