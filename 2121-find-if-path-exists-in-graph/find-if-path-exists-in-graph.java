class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> G = new HashMap<>();
        for (int[] edge: edges) {
            int a = edge[0], b = edge[1];
            G.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            G.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }

        boolean[] seen = new boolean[n];
        seen[source] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);

        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == destination) return true;
            for (int neighbor: G.get(node)) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
        return false;
    }
}