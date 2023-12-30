class Solution {
    public int longestConsecutive(int[] nums) {

        Map<Integer, Boolean> visited = new HashMap<>();
        // Set<Integer> table = new HashSet<>();
        int l = 0, result = 0;
        for (int x : nums) { visited.put(x, false);}
        // for (int i = 0; i < nums.length; i++) {
        //     if (!visited.get(nums[i])) {
        //         visited.put(nums[i], true);
        //         l = 1;
        //         int x = nums[i];
        //         while (table.contains(x - 1) && !visited.get(x - 1)) {
        //             visited.put(x - 1, true);
        //             l++;
        //             x--;
        //         }
        //         x = nums[i];
        //         while (table.contains(x + 1) && !visited.get(x + 1)) {
        //             visited.put(x + 1, true);
        //             l++;
        //             x++;
        //         }
        //         result = Math.max(result, l);
        //     }
        // }
        for (int num: visited.keySet()) {
            if (!visited.get(num)) {
                visited.put(num, true);
                l = 1;
                int x = num;
                while (visited.containsKey(x - 1) && !visited.get(x - 1)) {
                    visited.put(x - 1, true);
                    l++;
                    x--;
                }
                x = num;
                while (visited.containsKey(x + 1) && !visited.get(x + 1)) {
                    visited.put(x + 1, true);
                    l++;
                    x++;
                }
                result = Math.max(result, l);
            }
        }
        return result;
    }
}