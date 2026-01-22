class Solution {
    public int vowelConsonantScore(String s) {
        int n = s.length();
        int v = 0, c = 0;
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('o');vowels.add('i');vowels.add('u');
        for (char ch: s.toCharArray()) {
            if (vowels.contains(ch)) v++;
            else if (Character.isAlphabetic(ch)) c++;
        }
        if (c == 0) return 0;
        // System.out.println(v + " " + c);
        return v / c;
    }
}