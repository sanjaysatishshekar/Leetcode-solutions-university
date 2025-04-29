class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        Map<Character, String> table = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", 
        '7', "pqrs", '8', "tuv", '9', "wxyz");
        backtrack(result, digits, table, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, Map<Character, String> table, StringBuilder current, int index) {
        if (digits.length() == index) {
            result.add(current.toString());
            return;
        }
        String s = table.get(digits.charAt(index));
        for (char c: s.toCharArray()) {
            current.append(c);
            backtrack(result, digits, table, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
/*
get the digits
    "23"
    have a map for all the digits,
    
    pick the first digit
    get the list of all the letters that is corresponds
    iterate thru each of them
        add it to the string
        check if it's of the same length and add it
        Here we can say having a index is most vital
        remove it now
*/