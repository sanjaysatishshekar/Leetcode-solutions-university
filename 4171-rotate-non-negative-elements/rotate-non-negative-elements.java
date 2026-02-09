class Solution {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> val = new ArrayList<>();
        List<Integer> ind = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > -1) {
                val.add(nums[i]);
                ind.add(i);
            }
        }
        if (val.size() == 0) return nums;
        k = k % val.size();
        ArrayList<Integer> r = new ArrayList<>(val.size());
        for (int i = k; i < val.size(); i++) 
            r.add(val.get(i));
        for (int i = 0; i < k; i++) 
            r.add(val.get(i));
        
        for (int i = 0; i < ind.size(); i++) {
            nums[ind.get(i)] = r.get(i);
        }
        return nums;



    }
}