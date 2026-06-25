class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // 1. Build Adjacency List
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj[u].add(new int[]{v, weight});
        }

        // 2. Initialize 2D Distance Array: dist[node][streak]
        int[][] dist = new int[n][k + 1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // 3. Min-Heap Priority Queue sorted by distance: [distance, node, streak]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // Base case: start at node 0, cost 0, consecutive streak is 1
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            int streak = curr[2];

            // If we found a shorter path to this state already, skip it
            if (d > dist[u][streak]) continue;

            // If we reached the destination, because it's a min-heap, this is our shortest path
            if (u == n - 1) return d;

            // 4. Explore Neighbors
            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                
                int nextStreak;
                // Condition A: Character matches -> Increment streak
                if (labels.charAt(v) == labels.charAt(u)) {
                    nextStreak = streak + 1;
                } else { 
                    // Condition B: Character is different -> Reset streak to 1
                    nextStreak = 1;
                }

                // Only proceed if the streak is within the legal limit 'k'
                if (nextStreak <= k) {
                    if (d + weight < dist[v][nextStreak]) {
                        dist[v][nextStreak] = d + weight;
                        pq.offer(new int[]{d + weight, v, nextStreak});
                    }
                }
            }
        }

        // If the queue empties and we never reached n - 1, no valid path exists
        return -1;
    }
}