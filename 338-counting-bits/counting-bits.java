class Solution {
    // public int[] countBits(int n) {
    //     int[] result = new int[n + 1];
    //     for (int i = 0; i <= n; i++) {
    //         int count = 0;
    //         for (int j = 0; j < 32; j++) {
    //             int bit = (i >> j) & 1;
    //             if (bit == 1) count++;
    //         }
    //         result[i] = count;
    //     }
    //     return result;
    // }

    public int[] countBits(int n) {
        int res[] = new int[n+1];
        for(int num = 0; num <= n; num++){
            res[num] = (bitCount(num));
        }
        return res;
    }
    private int bitCount(int num){
         int count = 0;
        while(num > 0){
            count++;
            num &= (num-1);
        }
        return count;
    }    
 
}