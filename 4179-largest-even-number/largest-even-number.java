class Solution {
    public String largestEven(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        int i =  n - 1;
        while (i >= 0 && sb.charAt(i) != '2') {
            sb.deleteCharAt(i);
            i--;
        }
        return sb.toString();
        
    }
}