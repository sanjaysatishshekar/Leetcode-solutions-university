class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> l = new ArrayList<>();
        List<String> d = new ArrayList<>();

        for( String log : logs){
            if(Character.isDigit(log.charAt(log.indexOf(' ')+1))){
                d.add(log);
            }
            else{
                l.add(log);
            }
        }
        
        Collections.sort(l,new Comparator<String>(){
            public int compare(String log1,String log2){
                String l1 = log1.substring(log1.indexOf(' ')+1,log1.length());
                String l2 = log2.substring(log2.indexOf(' ')+1,log2.length());
                
                if(l1.equals(l2)){
                    return log1.compareTo(log2);

                }
                return l1.compareTo(l2);
            }
        });
        List<String> res = new ArrayList<>();
        res.addAll(l);
        res.addAll(d);
        return res.toArray(new String[0]);
        
        
    }
}

// class Solution {
//     public String[] reorderLogFiles(String[] logs) {
//         int n = logs.length;
//         String[] result = new String[n];
//         List<String> nums = new ArrayList<>();
//         PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> {
//             int cmp = a[1].compareTo(b[1]);
//             if (cmp == 0) return a[0].compareTo(b[0]);
//             return cmp;
//         });
        
//         for (String log: logs) {
//             String[] s = log.split(" ");
//             if (Character.isDigit(s[1].charAt(0)))
//                 nums.add(log);
//             else  {
//                 String id = log.substring(0, log.indexOf(" "));
//                 String content = log.substring(log.indexOf(" "));
//                 pq.offer(new String[]{id, content, log});
//             }
//         }
//         int idx = 0;
//         while (idx < n) {
//             while (!pq.isEmpty()) {
//                 result[idx++] = pq.poll()[2];
//             }
//             for (String num: nums) {
//                 result[idx++] = num;
//             }
//         }
//         return result;
//     }
// }