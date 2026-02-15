class Solution {
    public int firstUniqueFreq(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> table = new HashMap<>();
        int[] freqCount = new int[n + 1];
        for (int num: nums) {
            table.put(num, table.getOrDefault(num, 0) + 1);
        }
        for (int num: table.keySet()) {
            freqCount[table.get(num)]++;
        }
        Set<Integer> seen = new HashSet<>();
        for (int num: nums) {
            int f = table.get(num);
            if (!seen.contains(f)) {
                if (freqCount[f] == 1) 
                    return num;
                seen.add(f);
            }
        }
        return -1;
        
    }
}