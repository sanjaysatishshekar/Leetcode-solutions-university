class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> days = new ArrayList<>();
        int n = security.length;
        
        if (time > n) return days;    

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) 
                left[i] = left[i - 1] + 1;
            else {
                left[i] = 0;
            }
        }
        System.out.println(Arrays.toString(left));

        for (int i = n - 2; i > -1; i--) {
            if (security[i] <= security[i + 1]) 
                right[i] = right[i + 1] + 1;
            else {
                right[i] = 0;
            }
        }
        System.out.println(Arrays.toString(right));

        for (int i = 0; i < n; i++) {
            if (left[i] >= time && right[i] >= time) 
                days.add(i);
        }
        return days;


    }

    // public List<Integer> goodDaysToRobBank(int[] security, int time) {
    //     List<Integer> days = new ArrayList<>();
    //     int n = security.length;
        
    //     if (time > n) return days;

    //     for (int i = 0; i < n; i++) {
    //         if (i - time < 0 || i + time >= n) continue;
    //         boolean valid = true;
    //         for (int j = 0; j < time; j++) {
    //             if (security[i - j] > security[i - j - 1] ||
    //                 security[i + j] > security[i + j + 1])
    //                 valid = false;
    //         }
    //         if (valid) days.add(i);
    //     }
    //     return days;
    // }
}