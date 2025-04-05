class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        List<Integer> l = new ArrayList<>();
        while (x != 0) {
            l.add(x % 10);
            x = x / 10;
        }
        int i = 0, j = l.size() - 1;
        while (i < j) {
            if (l.get(i) != l.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}