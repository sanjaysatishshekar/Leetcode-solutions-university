class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        if (n == 1) return answer;

        for (int i = 0; i < n; i++) {
            int count = 0;
            boolean isPrevOdd = nums[i] % 2 == 1;
            boolean isEven = false;
            for (int j = i + 1; j < n; j++) {
                isEven = nums[j] % 2 == 1;
                if (isPrevOdd == !isEven) {
                    count++;
                }
                // System.out.println(i + " " + j + " " + isPrevOdd + " " + isEven + " " + count);
            }
            
            answer[i] = count;
        }
        return answer;
    }
}