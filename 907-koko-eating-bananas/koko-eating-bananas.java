class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int high = 0, low = 1;
        for (int pile: piles) {
            high = Math.max(high, pile);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            int timeTaken = isPossibleToEat(piles, mid);
            System.out.println(mid + " " + timeTaken);
            if (timeTaken <= h)
                high = mid;
            else
                low = mid + 1;
        }
        return high;
    }

    private int isPossibleToEat(int[] piles, int k) {
        int total = 0;
        for (int pile: piles) {
            total += ((pile + k - 1) / k);
        }
        return total;
    }
}