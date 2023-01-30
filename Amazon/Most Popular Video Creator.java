class pair{
    String creator;
    int view;
   public pair(String creator,int view){
        this.creator=creator;
        this.view=view;
    }
}
class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> ans=new ArrayList<>();
        Map<String,Long>map=new HashMap<>();
        Map<String,PriorityQueue<pair>> map2=new HashMap<>();
        int n=creators.length;
        for(int i=0;i<n;i++){
            if(!map.containsKey(creators[i])){
                map.put(creators[i],(long)views[i]);
            }
            else
                map.put(creators[i],(map.get(creators[i])+(long)views[i]));
            if(!map2.containsKey(creators[i])){
                map2.put(creators[i],new PriorityQueue<>((x,y)->x.view==y.view?(x.creator.compareTo(y.creator)):y.view-x.view));
            }    
            map2.get(creators[i]).add(new pair(ids[i],views[i]));
        }
        long max=0;
        for(long val:map.values())
        max=Math.max(max,val);
        for(String c:map.keySet()){
            if(map.get(c)==max){
                List<String> temp=new ArrayList<>();
                temp.add(c);
                PriorityQueue<pair> pq=map2.get(c);
                temp.add(pq.poll().creator);
                ans.add(temp);
            }
        }
        return ans;
    }
}