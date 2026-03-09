class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int result = -1;
        int size = Integer.MAX_VALUE;
        for (int i = 0; i < capacity.length; i++) {
            int num = capacity[i]; 
            if (itemSize <= num && size > num) {
                size = num;
                result = i;
            }
        }
        return result;
    }
}