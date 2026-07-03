import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxCost = 0;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});
            indegree[v]++;
            maxCost = Math.max(maxCost, w);
        }

        
        int[] topo = new int[n];
        int idx = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] deg = indegree.clone();

        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo[idx++] = u;

            for (int[] next : graph[u]) {
                if (--deg[next[0]] == 0) {
                    queue.offer(next[0]);
                }
            }
        }

        int left = 0, right = maxCost;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canReach(mid, graph, topo, online, k, n)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canReach(int limit, List<int[]>[] graph, int[] topo,
                             boolean[] online, long k, int n) {

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == INF) continue;

            if (u != 0 && u != n - 1 && !online[u]) continue;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];

                if (w < limit) continue;

                if (v != 0 && v != n - 1 && !online[v]) continue;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}