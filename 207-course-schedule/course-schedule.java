class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pt : prerequisites) {
            adj.get(pt[0]).add(pt[1]);
        }
        int[] indegree = new int[numCourses];
        for (int u = 0; u < numCourses; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        // Step 3: Add nodes with 0 indegree to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 4: Perform Kahn's algorithm
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return ans.size()==numCourses;
    }
}