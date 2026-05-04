class Solution {
    public boolean validDigit(int n, int x) {
        char[] num = String.valueOf(n).toCharArray();
        char digit = Character.forDigit(x, 10);
        for (int i = 0; i < num.length; i++) {
            if (i == 0 && num[i] == digit)
                return false;
            if (num[i] == digit)
                return true;
        }
        return false;
    }
}