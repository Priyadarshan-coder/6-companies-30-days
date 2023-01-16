class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold){
  int dist[][]=new int[n][n];
  int inf=(int)1e9+7;
  for(int i=0;i<n;i++)
  {
    Arrays.fill(dist[i],inf);
    dist[i][i]=0;     
  }
  for(int []edge:edges)
  {
      int u=edge[0];
      int v=edge[1];
      int wt=edge[2];
      dist[u][v]=wt;
      dist[v][u]=wt;
  }
  
  for(int k=0;k<n;k++)
  {
      for(int i=0;i<n;i++)
      {
          for(int j=0;j<n;j++)
          {
              dist[i][j]=Math.min(dist[i][j],dist[k][j]+dist[i][k]);
          }
      }
  }
  int cityno=-1;
  int citymax=n;
  for(int city=0;city<n;city++)
  {
      int cnt=0;
      for(int adjcity=0;adjcity<n;adjcity++)
      {
          if(city==adjcity)continue;
          if(dist[city][adjcity]<=distanceThreshold)
          {
              cnt++;
          }
      }
          if(cnt<=citymax)
          {
              citymax=cnt;
              cityno=city;
          }
      }
  
      return cityno;
  }
}
