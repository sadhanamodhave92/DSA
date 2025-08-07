import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Correct edge direction: pt[1] → pt[0]
        for (int[] pt : prerequisites) {
            adj.get(pt[1]).add(pt[0]);
        }

        int[] indegree = new int[numCourses];
        for (int u = 0; u < numCourses; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

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

        // Check if all courses were added (no cycle)
        if (ans.size() != numCourses) {
            return new int[0];
        }

        // Convert List<Integer> to int[]
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
