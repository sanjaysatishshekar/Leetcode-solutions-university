class Solution {
    public String trimTrailingVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('o');
        vowels.add('i');
        vowels.add('u');
        StringBuilder result = new StringBuilder(s);
        while (result.length() > 0 && vowels.contains(result.charAt(result.length() - 1))) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
}