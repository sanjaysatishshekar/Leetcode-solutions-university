class Solution {
    public int minimumChairs(String s) {
        int maxChairs = 0;
        int currentChairs = 0;
        for (char c: s.toCharArray()) {
            if (c == 'E'){
                currentChairs += 1;
                maxChairs = Math.max(maxChairs, currentChairs);
            }
            else
                currentChairs -= 1;
        }
        return maxChairs;
    }
}