class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        ArrayDeque<Integer> mx = new ArrayDeque<>();        
        ArrayDeque<Integer> mn = new ArrayDeque<>();        
        long c = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            while (!mx.isEmpty() && nums[mx.peekLast()] <= nums[r])
                mx.pollLast();
            mx.addLast(r);
            while (!mn.isEmpty() && nums[mn.peekLast()] >= nums[r])
                mn.pollLast();
            mn.addLast(r);

            while (l <= r && (long) (r - l + 1) * (nums[mx.peekFirst()] - nums[mn.peekFirst()]) > k) {
                if (!mx.isEmpty() && mx.peekFirst() <= l) 
                    mx.pollFirst();
                if (!mn.isEmpty() && mn.peekFirst() <= l) 
                    mn.pollFirst();
                l++;
            }
            c += (r - l + 1); 
        }
        return c;



        // long c = 0;
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     long mx = nums[i], mn = nums[i];
        //     for (int j = i; j < n; j++) {
        //         mx = Math.max(mx, nums[j]);
        //         mn = Math.min(mn, nums[j]);
        //         long r = (mx - mn) * (j - i + 1);
        //         if (r <= k) c++;
        //     }
        // }
        // return c;
    }
}