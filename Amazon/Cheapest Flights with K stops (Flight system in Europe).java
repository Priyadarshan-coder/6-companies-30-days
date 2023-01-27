class pair{
    int first;
    int second;
    public pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class tuple{
    int stops;
    int node;
    int cost;
    public tuple(int stops,int node,int cost)
    {
        this.stops=stops;
        this.node=node;
        this.cost=cost;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>>adj=new ArrayList<>();
        int m=flights.length;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
        }
        Queue<tuple> q=new LinkedList<>();
        q.add(new tuple(0,src,0));
        int []dist=new int [n];
        for(int i=0;i<n;i++)
        {
            dist[i]=(int)(1e9);
        }
        dist[src]=0;
        while(!q.isEmpty())
        {
            tuple it=q.peek();
            q.remove();
            int stops=it.stops;
            int node=it.node;
            int cost=it.cost;
            if(stops>k)break;
            for(pair iter:adj.get(node))
            {
                int adjnode=iter.first;
                int edwt=iter.second;
                if(edwt+cost<dist[adjnode] && stops<=k)
                {
                    dist[adjnode]=edwt+cost;
                    q.add(new tuple(stops+1,adjnode,cost+edwt));
                }
            }
        }
        if(dist[dst]==(int)(1e9))return -1;
        return dist[dst];
            }
        }