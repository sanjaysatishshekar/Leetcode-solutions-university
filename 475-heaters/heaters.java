class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int n = heaters.length;
        int result = 0;
        int distance = 0;
        for (int house: houses) {
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (heaters[mid] < house) {
                    left = mid + 1;
                }
                else right = mid;
            }
            distance = Math.abs(heaters[left] - house);
            if (left > 0)
                distance = Math.min(distance, Math.abs(heaters[left - 1] - house));
            result = Math.max(result, distance);
        }
        return result;
    }
}