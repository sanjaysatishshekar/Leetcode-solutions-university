// import java.utils.*;
class Solution {
    public int lengthOfLastWord(String s) {
        String[] a = s.split(" ");
        System.out.println(Arrays.toString(a));
        // for (String d: a) {
            // System.out.println(d);
        // }
        // return -1;
        if (a.length >= 1) return a[a.length - 1].length();
        return 0;

    }
}