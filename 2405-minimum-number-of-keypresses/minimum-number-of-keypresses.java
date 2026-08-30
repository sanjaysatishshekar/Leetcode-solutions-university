class Solution {
    public int minimumKeypresses(String s) {
        Integer[] counts = new Integer[26];
        Arrays.fill(counts, 0);
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        int ans = 0;
        Arrays.sort(counts, (a, b) -> b - a);
        for (int i = 0;i < 26; i++) {
            if (i < 9) 
                ans += counts[i];
            else if (i < 18) 
                ans += 2 * counts[i];
            else
                ans += 3 * counts[i]; 
        }
        return ans;

    }
}