class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        // Set<Character> seen = new HashSet<>();
        // for (int i = 0; i < n - 1; i++) {
        //     seen.add(s.charAt(i));
        //     for (int j = i + 1; j < n; j++) {
        //         if (seen.contains(s.charAt(j))) {
        //             break;
        //         }
        //         seen.add(s.charAt(j));
        //         result = Math.max(result, j - i + 1);
        //     }
        //     seen.clear();
        // }
        int i = 0, j = 0;
        int[] counts = new int[128];
        while (i < n && j < n) {
            counts[s.charAt(j)]++;
            while (i < n && counts[s.charAt(j)] > 1) {
                counts[s.charAt(i)]--;
                i++;
            }
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }
}