class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        String[] result = new String[n];
        List<String> nums = new ArrayList<>();
        PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> {
            int cmp = a[1].compareTo(b[1]);
            if (cmp == 0) return a[0].compareTo(b[0]);
            return cmp;
        });
        
        for (String log: logs) {
            String[] s = log.split(" ");
            if (Character.isDigit(s[1].charAt(0)))
                nums.add(log);
            else  {
                String id = log.substring(0, log.indexOf(" "));
                String content = log.substring(log.indexOf(" "));
                pq.offer(new String[]{id, content, log});
            }
        }
        int idx = 0;
        while (idx < n) {
            while (!pq.isEmpty()) {
                result[idx++] = pq.poll()[2];
            }
            for (String num: nums) {
                result[idx++] = num;
            }
        }
        return result;
    }
}