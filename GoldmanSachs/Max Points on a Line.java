class Solution {
    public int maxPoints(int[][] points) {
       
        int ans=0;
        for(int i=0;i<points.length;i++)
        {
             HashMap<Double,Integer>map=new HashMap<>();
             for(int j=0;j<points.length;j++)
             {
                 if(i==j)continue;
                 double slope=0;
                  if(points[j][0]==points[i][0]) slope=Double.MAX_VALUE; 
                 else{
                  slope=(points[j][1]-points[i][1])/(double)(points[j][0]-points[i][0]);
                 }
                 map.put( slope , map.getOrDefault(slope,0)+1 );
               ans=Math.max(ans,map.get(slope));
             }
        }
        return ans+1;
    }
}