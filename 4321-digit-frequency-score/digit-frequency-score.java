class Solution {
    public int digitFrequencyScore(int n) {
        int[] table = new int[10];
        String num = String.valueOf(n);
        for (int i = 0; i < num.length(); i++) {
            table[num.charAt(i) - '0']++;
        }
        int sum = 0;
        // System.out.println(Arrays.toString(table));
        for (int i = 0; i <= 9; i++) {
            sum += (i * table[i]);
        }
        return sum;
    }
}