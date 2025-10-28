class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] table = new int[26];
        for (int task: tasks) {
            table[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());   
        for (int i: table) {
            if (i != 0) pq.offer(i);
        }
        int timeTaken = 0;
        while (!pq.isEmpty()) {
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            int cycle = n + 1;
            while (cycle-- > 0 && !pq.isEmpty()) {
                int currentf = pq.poll();
                if (currentf > 1) {
                    store.add(currentf - 1);
                }
                taskCount++;
            }
            for (int i: store) {
                pq.offer(i);
            }
            if (pq.isEmpty()) {
                timeTaken += taskCount;
            }
            else {
                timeTaken += (n + 1);
            }
        }
        return timeTaken;
    }
}