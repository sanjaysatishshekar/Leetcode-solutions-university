class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] b = new boolean[101];
        List<Integer> result = new ArrayList<>();
        for (int bulb: bulbs) {
            b[bulb] = !b[bulb];
        }
        for (int i = 0; i < 101; i++) { 
            if (b[i]) result.add(i);
        }
        return result;
    }
}