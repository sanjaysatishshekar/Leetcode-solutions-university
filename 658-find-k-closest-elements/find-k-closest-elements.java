class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        if (arr.length == k) {
            for (int i = 0; i < k; i++) result.add(arr[i]);
            return result;
        }
        
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x)
                right = mid;
            else
                left = mid + 1;
        }

        left -= 1;
        right = left + 1;
        while (right - left - 1 < k) {
            if (left == -1) {
                right += 1;
                continue;
            }
            if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left -= 1;
            }
            else {
                right += 1;
            }
        }
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }
        return result;


        // List<Integer> result = new ArrayList<>();
        // Map<Integer, List<Integer>> map = new HashMap<>();
        // for (int num : arr) {
        //     int key = Math.abs(num - x);
        //     map.putIfAbsent(key, new ArrayList<>());
        //     map.get(key).add(num);
        // }

        // while (k != 0) {
        //     for (int i = 0; i < arr.length; i++) {
        //         if (map.containsKey(i)) {
        //             for (int num : map.get(i)) {
        //                 result.add(num);
        //                 k--;
        //             }
        //         }
        //     }
        // }
        // return result;

    }
}