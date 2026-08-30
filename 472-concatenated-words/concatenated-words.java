class Solution {
    class Node {
        Node[] arr = new Node[26];
        boolean isEnd;
    }

    private void insert(Node root, String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.arr[idx] == null) {
                curr.arr[idx] = new Node();
            }

            curr = curr.arr[idx];
        }

        curr.isEnd = true;
    }

    private boolean dfs(Node root, String word, int index, Boolean[] memo) {
        if (index == word.length()) {
            return true;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        Node curr = root;

        for (int i = index; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.arr[idx] == null) {
                break;
            }

            curr = curr.arr[idx];

            // Found a dictionary word: word[index...i]
            if (curr.isEnd) {
                if (dfs(root, word, i + 1, memo)) {
                    return memo[index] = true;
                }
            }
        }

        return memo[index] = false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
       
        Arrays.sort(words, Comparator.comparingInt(String::length));

        Node root = new Node();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }

            Boolean[] memo = new Boolean[word.length()];

            // Check BEFORE inserting the current word
            if (dfs(root, word, 0, memo)) {
                result.add(word);
            }

            insert(root, word);
        }

        return result;
    }
}