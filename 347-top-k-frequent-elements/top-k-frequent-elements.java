class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int num: nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int key: frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        int j = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) 
                continue;
            for (int num : buckets[i]) {
                result[j] = num;
                j = j + 1;
                if (j == k) {
                    return result;
                }
            }
        }
        return result;
    }

    /* Using PriorityQueue
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
    */
}