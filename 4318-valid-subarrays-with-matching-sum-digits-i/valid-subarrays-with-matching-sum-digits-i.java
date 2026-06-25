class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int count = 0;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        if (check(nums[0], x)) count++; 
        
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            if (check(prefix[i], x))
                count++;
            if (check(nums[i], x))
                count++;
        }
        
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(prefix[j] - prefix[i - 1], x))
                    count++;
            }
        }
        return count;
    }
    
    private boolean check(long sum, int x) {
        String num = String.valueOf(sum);
        return (num.charAt(0) - '0') == x && (num.charAt(num.length() - 1) - '0') == x;
    }
}

// 1 100 1
// 1 101 102

// 102 101 1


// a, b, c, d
// a, a+b, a+b+c, a+b+c+d
// 0, 1,    2,     3
