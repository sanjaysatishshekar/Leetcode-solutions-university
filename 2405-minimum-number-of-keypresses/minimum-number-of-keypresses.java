class Solution {
    public int minimumKeypresses(String s) {
        int[] counts = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        int result = 0;
        Arrays.sort(counts);
        for (int i = 25; i > -1; i--) {
            if (i > 16) 
                result += counts[i];
            else if (i > 7) 
                result += 2 * counts[i];
            else
                result += 3 * counts[i]; 
        }
        return result;

    }
}