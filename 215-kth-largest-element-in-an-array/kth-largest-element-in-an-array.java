class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for (int num: nums) {
        // pq.offer(num);
        // if (pq.size() > k)
        // pq.poll();
        // }
        // return pq.poll();
        int n = nums.length;
        int target = n - k;
        return quickselect(nums, 0, n - 1, target);
    }

    private int quickselect(int[] nums, int left, int right, int target) {
        if (left == right) return nums[left];
        int pivot = nums[left];
        int low = left;
        int high = right;
        while (low <= high) {
            while (low <= high && nums[low] < pivot)
                low++;
            while (low <= high && nums[high] > pivot)
                high--;
            if (low <= high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
        if (target <= high) {
            return quickselect(nums, left, high, target);
        }
        else if (target >= low) {
            return quickselect(nums, low, right, target);
        }
        else {
            return nums[target];
        }
        
    }
}