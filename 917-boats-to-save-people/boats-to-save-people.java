class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0, j = n - 1;
        int result = 0;
        while (i <= j) {
            result++; 
            if (people[i] + people[j] <= limit)
                i++;
            j--;

        }
        return result;
    }
}