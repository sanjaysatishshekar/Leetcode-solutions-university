class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] i: flights) {
            adj.computeIfAbsent(i[0], val -> new ArrayList<>()).add(new int[]{i[1], i[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        int stops = 0;
        while (stops <= k && !q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] temp = q.poll();
                int node = temp[0];
                int distance = temp[1];

                if (!adj.containsKey(node)) continue;

                for (int[] e: adj.get(node)) {
                    int neighbor = e[0];
                    int price = e[1];
                    if (price + distance >= dist[neighbor])
                        continue; 
                    dist[neighbor] = price + distance;
                    q.offer(new int[]{neighbor, dist[neighbor]});
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}