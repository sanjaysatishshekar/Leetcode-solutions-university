class Solution {
    public int passwordStrength(String password) {
        Set<Character> seen = new HashSet<>();
        int strength = 0;
        for (char c: password.toCharArray()) {
            if (seen.contains(c)) continue;
            seen.add(c);
            if ('a' <= c && c <= 'z')
                strength += 1;
            else if ('A' <= c && c <= 'Z')
                strength += 2;
            else if ('0' <= c && c <= '9')
                strength += 3;
            else
                strength += 5;
        }
        return strength;
    }
}