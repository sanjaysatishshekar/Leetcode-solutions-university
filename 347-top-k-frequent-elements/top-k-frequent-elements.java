class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> table = new HashMap<>();
        for (int num: nums) {
            table.put(num, table.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> table.get(b) - table.get(a));
        for (int key: table.keySet()) {
            pq.add(key);
        }
        int i = 0;
        for (int j = 0; j < k; j++) {
            int val = pq.poll();
            result[i] = val;
            i++;
        }
        return result;
    }
}