class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = numCourses;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] pre: prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        int nodesVisited = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            nodesVisited++;
            for (int neighbors: adj.get(node)) {
                indegree[neighbors]--;
                if (indegree[neighbors] == 0)
                    q.offer(neighbors);
            }
        }
        return nodesVisited == n;
    }
}