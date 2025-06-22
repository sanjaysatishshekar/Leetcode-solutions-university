class Solution {
    private List<Integer> generate() {
        int n = 100;
        List<Integer> result = new ArrayList<>();
        boolean[] table = new boolean[101];
        for (int i = 2; i <= 100; i++) {
            for (int j = i + i; j <= 100; j += i) {
                if (!table[j]) table[j] = true;
            }
        }
        // System.out.println(Arrays.toString(table));
        for (int i = 2; i <= 100; i++) {
            if (!table[i]) result.add(i);
        }
        return result;
    }
    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer, Integer> table = new HashMap<>();
        List<Integer> primes = generate();
        // for (Integer num: primes) {
        //     System.out.println("hello" + " " + num);
        // }
        for (int num: nums) {
            table.put(num, table.getOrDefault(num, 0) + 1);
        }
        // for (int key: table.keySet()) {
        //     System.out.println(key + " " + table.get(key));
        // }
        for (int val: table.values()) {
            if (primes.contains(val)) return true;
        }
    
        return false;

        
    }
}