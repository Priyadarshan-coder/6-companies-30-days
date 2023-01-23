class pair {
        int dist;
        int node;
      public pair(int node, int dist) {
            this.dist = dist;
            this.node = node;
        }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] time: times) {
            graph[time[0]].add(new int[]{time[1],time[2] });
        }

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        PriorityQueue<pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        pq.add(new pair(k, 0));
        while (!pq.isEmpty()) {
            pair iter = pq.poll();
            int curDist = iter.dist;
            int curnode = iter.node;
            if (minDist[curnode] <= curDist)
                continue;
            minDist[curnode] = curDist;
            for (int[] adj: graph[curnode]) {
                int newDist = minDist[curnode] + adj[1];
                int adjnode = adj[0];
                if (minDist[adjnode] > newDist) {
                    pq.offer(new pair(adjnode, newDist));
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (minDist[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, minDist[i]);
        }
        return ans;
    }
}