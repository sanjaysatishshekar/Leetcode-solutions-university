class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? (a.charAt(i) - '0') : 0;
            int y = j >= 0 ? (b.charAt(j) - '0') : 0;
            int sum = x + y + carry;
            result.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry > 0)
            result.append(carry);
        return result.reverse().toString();

    }
}