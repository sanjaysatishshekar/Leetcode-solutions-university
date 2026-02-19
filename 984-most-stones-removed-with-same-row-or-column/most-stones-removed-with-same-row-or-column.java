// class Solution {
//     public int removeStones(int[][] stones) {
//         int n = stones.length;

//         List<Integer>[] adj = new List[n];
//         for (int i = 0; i < n; i++) {
//             adj[i] = new ArrayList<>();
//         }
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (stones[i][0] == stones[j][0] ||
//                 stones[i][1] == stones[j][1]) {
//                     adj[i].add(j);
//                     adj[j].add(i);
//                 }
//             }
//         }

//         int connectedComponents = 0;
//         boolean[] visited = new boolean[n];

//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 dfs(adj, visited, i);
//                 connectedComponents++;
//             }
//         }
//         return n - connectedComponents;
//     }

//     void dfs(List<Integer>[] adj, boolean[] visited, int node) {
//         visited[node] = true;
//         for (int neighbor: adj[node])  {
//             if (!visited[node]) {
//                 dfs(adj, visited, neighbor);
//             }
//         }

//     }
// }

class Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;

        // Adjacency list to store graph connections
        List<Integer>[] adjacencyList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // Build the graph: Connect stones that share the same row or column
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (
                    stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]
                ) {
                    adjacencyList[i].add(j);
                    adjacencyList[j].add(i);
                }
            }
        }

        int numOfConnectedComponents = 0;
        boolean[] visited = new boolean[n];

        // Traverse all stones using DFS to count connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depthFirstSearch(adjacencyList, visited, i);
                numOfConnectedComponents++;
            }
        }

        // Maximum stones that can be removed is total stones minus number of connected components
        return n - numOfConnectedComponents;
    }

    // DFS to visit all stones in a connected component
    private void depthFirstSearch(
        List<Integer>[] adjacencyList,
        boolean[] visited,
        int stone
    ) {
        visited[stone] = true;

        for (int neighbor : adjacencyList[stone]) {
            if (!visited[neighbor]) {
                depthFirstSearch(adjacencyList, visited, neighbor);
            }
        }
    }
}

// class UnionFind {

//         int[] parent; // Array to track the parent of each node
//         int componentCount; // Number of connected components
//         Set<Integer> uniqueNodes; // Set to track unique nodes

//         UnionFind(int n) {
//             parent = new int[n];
//             Arrays.fill(parent, -1); // Initialize all nodes as their own parent
//             componentCount = 0;
//             uniqueNodes = new HashSet<>();
//         }

//         // Find the root of a node with path compression
//         int find(int node) {
//             // If node is not marked, increase the component count
//             if (!uniqueNodes.contains(node)) {
//                 componentCount++;
//                 uniqueNodes.add(node);
//             }

//             if (parent[node] == -1) {
//                 return node;
//             }
//             return parent[node] = find(parent[node]);
//         }

//         // Union two nodes, reducing the number of connected components
//         void union(int node1, int node2) {
//             int root1 = find(node1);
//             int root2 = find(node2);

//             if (root1 == root2) {
//                 return; // If they are already in the same component, do nothing
//             }

//             // Merge the components and reduce the component count
//             parent[root1] = root2;
//             componentCount--;
//         }
//     }