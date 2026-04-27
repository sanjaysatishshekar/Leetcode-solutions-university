class Letter {
    char c;
    int count;

    public Letter(char c, int count) {
        this.c = c;
        this.count = count;
    }

    public String toString() {
        return c + " " + count;
    }
}
class Solution {
    public String sortVowels(String s) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> table = new HashMap<>();
        int[] counts = new int[26];
        PriorityQueue<Letter> pq = new PriorityQueue<>((a, b) -> {
            if (a.count == b.count)
                return table.get(a.c) - table.get(b.c);
            return b.count - a.count;
        });

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.contains(c)) {
                if (!table.containsKey(c)) 
                    table.put(c, i);
            }
            counts[c - 'a']++;
        }

        for (char a: table.keySet()) {
            pq.offer(new Letter(a, counts[a - 'a']));
        }
        // while (!pq.isEmpty()) {
        //     System.out.println(pq.poll());
        // }
        Letter a = null;
        for (char x: s.toCharArray()) {
            if (vowels.contains(x)) {
                if (a == null || a.count == 0)
                    a = pq.poll();
                result.append(a.c);
                a.count = a.count - 1;
            }
            else {
                result.append(x);
            }
        }

        return result.toString();
    }
}