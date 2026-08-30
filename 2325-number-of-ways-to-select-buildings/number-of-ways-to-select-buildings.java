class Solution {
    public long numberOfWays(String s) {
        int totalZero = 0;
        int totalOne = 0;
        for (char c: s.toCharArray()) {
            if (c == '0') totalZero++;
            else totalOne++;
        }

        long zeroLeft = s.charAt(0) == '0' ? 1 : 0;
        long oneLeft = s.charAt(0) != '0' ? 1 : 0;

        long result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                result += (oneLeft * (totalOne - oneLeft));
                zeroLeft++;
            }
            else {
                result += (zeroLeft * (totalZero - zeroLeft));
                oneLeft++;
            }
        }
        return result;

        // int n = s.length();
        // int zero = 0;
        // long zeroOne = 0;
        // int one = 0;
        // long oneZero = 0;
        // long total = 0;

        // for (char c: s.toCharArray()) {
        //     if (c == '0') {
        //         zero++;
        //         oneZero += one;
        //         total += zeroOne;
        //     }
        //     else {
        //         one++;
        //         zeroOne += zero;
        //         total += oneZero;
        //     }
        // }
        // return total;
    }
}