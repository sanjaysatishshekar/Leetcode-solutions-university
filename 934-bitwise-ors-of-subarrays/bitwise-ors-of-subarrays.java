class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> answer = new HashSet<>();
        Set<Integer> current = new HashSet<>();
        current.add(0);
        for (int x: arr) {
            Set<Integer> current2 = new HashSet<>();
            for (int y: current) {
                current2.add(x | y);
            }
            current2.add(x);
            current = current2;
            answer.addAll(current);
        }
        return answer.size();
    }
}