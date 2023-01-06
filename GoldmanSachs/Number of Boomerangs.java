class Solution {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans=0;
        for(int i=0;i<points.length;i++)
        {
            for(int j=0;j<points.length;j++)
            {
                if(i==j)continue;
                int dis=(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                map.put(dis,map.getOrDefault(dis,0)+1);
            }
        for(int iter:map.values())
        {
            ans+=iter*(iter-1);

        }
        map.clear();
        }
        return ans;
    }
}