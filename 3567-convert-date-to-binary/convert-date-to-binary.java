class Solution {
    public String convertDateToBinary(String date) {
        String[] l = date.split("-");
        StringBuilder sb = new StringBuilder();
        int y = Integer.parseInt(l[0]);
        int m = Integer.parseInt(l[1]);
        int d = Integer.parseInt(l[2]);
        sb.append(Integer.toBinaryString(y)).append('-').append(Integer.toBinaryString(m)).append('-').append(Integer.toBinaryString(d));
        return sb.toString();
    }
}