class Solution {
    public int absDifference(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

        for (int num: nums) {
            min.offer(num);
            max.offer(num);
            if (min.size() > k) min.poll();
            if (max.size() > k) max.poll();
        }
        int maxSum = 0, minSum = 0;

        for (int i = 0; i < k; i++) {
            maxSum += max.poll();
            minSum += min.poll();
        }
        return Math.abs(maxSum - minSum);
    }
}