class tuple
{
    int row;
    int col;
    int time;
    public tuple(int time,int row,int col)
    {
        this.time=time;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int []drow={-1,0,+1,0};
        int []dcol={0,+1,0,-1};
        PriorityQueue<tuple>pq=new PriorityQueue<tuple>((x,y) -> x.time - y.time);
        int dist[][]=new int [grid.length][grid.length];
         for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=grid[0][0];
        pq.add(new tuple(grid[0][0],0,0));
        while(!pq.isEmpty())
        {
            tuple it=pq.peek();
            pq.remove();
            int t=it.time;
            int r=it.row;
            int c=it.col;
            for(int i=0;i<4;i++)
            {
                int newr=r+drow[i];
                int newc=c+dcol[i];
                if(newr>=0 && newr<grid.length && newc>=0 && newc<grid.length)
                {
                    if(t>grid[newr][newc] && t<dist[newr][newc])
                    {
                        dist[newr][newc]=t;
                        pq.add(new tuple(t,newr,newc));
                    }
                    else if(t< grid[newr][newc] && grid[newr][newc]<dist[newr][newc])
                    {
                        dist[newr][newc]=grid[newr][newc];
                        pq.add(new tuple(grid[newr][newc],newr,newc));
                    }
                }
            }
        }
            return dist[grid.length-1][grid.length-1];
        }
    }
