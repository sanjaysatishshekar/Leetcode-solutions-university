class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + (x % 10);
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }
    // public boolean isPalindrome(int x) {
    //     char[] num = String.valueOf(x).toCharArray();
    //     int i = 0, j = num.length - 1;
    //     while (i < j) {
    //         if (num[i] != num[j])
    //             return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
}
