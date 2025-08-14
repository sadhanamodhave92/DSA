class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
              Map<Integer, List<int[]>> adj = new HashMap<>();
        
        // Build adjacency list
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, cost});
        }

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        int steps = 0;
        
        while (!q.isEmpty() && steps <= k) {
            int size = q.size();
            // Make a copy of cost array to avoid updating in the same BFS level
            int[] tempCost = Arrays.copyOf(cost, n);
            while (size-- > 0) {
                int[] curr = q.poll();
                int node = curr[0];
                int cst = curr[1];
                
                if (!adj.containsKey(node)) continue;
                
                for (int[] edge : adj.get(node)) {
                    int v = edge[0];
                    int dist = edge[1];
                    if (tempCost[v] > cst + dist) {
                        tempCost[v] = cst + dist;
                        q.offer(new int[]{v, cst + dist});
                    }
                }
            }
            cost = tempCost;
            steps++;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];  
    }
}