class Graph {
    private Map<Integer, List<int[]>> graph = new HashMap<>();

    public Graph(int n, int[][] edges) {
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }
    }

    public void addEdge(int[] edge) {
        int fromNode = edge[0];
        int toNode = edge[1];
        int cost = edge[2];

        graph.computeIfAbsent(fromNode, k -> new ArrayList<>()).add(new int[]{toNode, cost});
    }

    public int shortestPath(int startNode, int endNode) {
        Map<Integer, Integer> minCosts = new HashMap<>();
        minCosts.put(startNode, 0);
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        heap.add(new int[]{0, startNode});

        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            int currentCost = current[0];
            int currentNode = current[1];

            if (currentNode == endNode) {
                return minCosts.get(endNode);
            }

            for (int[] neighbor : graph.getOrDefault(currentNode, Collections.emptyList())) {
                int newCost = currentCost + neighbor[1];
                if (newCost < minCosts.getOrDefault(neighbor[0], Integer.MAX_VALUE)) {
                    minCosts.put(neighbor[0], newCost);
                    heap.add(new int[]{newCost, neighbor[0]});
                }
            }
        }

        // If there is no path from startNode to endNode
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */