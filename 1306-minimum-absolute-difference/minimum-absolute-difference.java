class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i + 1 < n; i++) {
            min = Math.min(min, Math.abs(arr[i + 1] - arr[i]));
        }
        for (int i = 0; i + 1 < n; i++) {
            if (Math.abs(arr[i + 1] - arr[i]) == min)
                result.add(List.of(arr[i], arr[i + 1]));
        }
        return result;
    }
}