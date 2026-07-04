class Solution {
    public int minScore(int n, int[][] roads) {
       
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int a = road[0], b = road[1], dist = road[2];
            graph.get(a).add(new int[]{b, dist});
            graph.get(b).add(new int[]{a, dist});
        }
       
       
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        
        int minScore = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int dist     = neighbor[1];
                
               
                minScore = Math.min(minScore, dist);
                
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        
        return minScore;
    }
}