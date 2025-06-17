class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num: nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> counts.get(b) - counts.get(a));
        for (int num: counts.keySet()) {
            pq.offer(num);
        }
        int[] result = new int[k];
        int j = 0;
        for (int i = k; i > 0; i--) {
            result[j++] = pq.poll();
        }
        return result;
    }
}