class Solution {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] nearestLeftCandle = new int[s.length()];
        int[] nearestRightCandle = new int[s.length()];
        int candle = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|')
                candle = i;
            nearestLeftCandle[i] = candle;
        }
        candle = -1;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == '|')
                candle = i;
            nearestRightCandle[i] = candle;
        }
        
        int[] prefix = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            prefix[i + 1] = prefix[i];

            if (s.charAt(i) == '*')
                prefix[i + 1]++;
        }

        int[] result = new int[queries.length];
        
        int idx = 0;
        for (int[] query: queries) {
            int start = nearestRightCandle[query[0]];
            int end = nearestLeftCandle[query[1]];

            if (start == -1 || end == -1 || start >= end) 
                result[idx++] = 0;
            
            else {
                result[idx++] = prefix[end + 1] - prefix[start];
            }
        }   
        return result;


    }


    // BruteForce
    // public int[] platesBetweenCandles(String s, int[][] queries) {
    //     int[] result = new int[queries.length];
        
    //     int idx = 0;
    //     for (int[] query: queries) {
    //         result[idx++] = findPlatesSurroundedByCandles(s.substring(query[0], query[1] + 1));
    //     }   
    //     return result;
    // }

    // private int findPlatesSurroundedByCandles(String s) {
    //     int leftCandle = s.indexOf('|');
    //     int rightCandle = s.lastIndexOf('|');
    //     int plates = 0;

    //     if (leftCandle == rightCandle) return 0;

    //     for (int i = leftCandle; i < rightCandle; i++) {
    //         if (s.charAt(i) == '*')
    //             plates++;
    //     }
    //     return plates;
    // }
}