class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num: happiness) {
            pq.offer(num);
        }
        long total = 0;
        int turns = 0;
        for (int i = 0; i < k; i++) {
            total += Math.max(pq.poll() - turns, 0);
            turns++;
        }
        return total;
    }
}