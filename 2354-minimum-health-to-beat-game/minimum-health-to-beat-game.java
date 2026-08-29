class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int n = damage.length;
        long totalDamage = 0;
        int bestReduction = 0;
        for (int i = 0; i < n; i++) {
            totalDamage += damage[i];
            bestReduction = Math.max(bestReduction, Math.min(armor, damage[i]));
        }
        return totalDamage - bestReduction + 1; 

        // int n = damage.length;
        // long health = Long.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        //     long d = 0;
        //     for (int j = 0; j < n; j++) { 
        //         if (i == j) {
        //             d = d - Math.max(0, damage[j] - armor);
        //         }
        //         else {
        //             d = d - damage[j];
        //         }
                
        //     }
        //     health = Math.max(health, d);
        // }
        // return (health * -1) + 1;
    }
}