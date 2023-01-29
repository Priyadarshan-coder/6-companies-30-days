class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>map=new HashMap<>();
        for(String st:words)
        {
            map.put(st,map.getOrDefault(st,0)+1);
        }
        PriorityQueue<String>pq=new PriorityQueue<>((a,b) -> map.get(a).equals(map.get(b))?b.compareTo(a):map.get(a)-map.get(b));
        for(String iter:map.keySet())
        {
            pq.offer(iter);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        List<String>list=new ArrayList<>();
        while(!pq.isEmpty())
        {
            list.add(pq.poll());
        }
         Collections.reverse(list);
         return list;
    }
}