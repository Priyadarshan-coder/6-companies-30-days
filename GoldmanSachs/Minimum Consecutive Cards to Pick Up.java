class Solution {
    public int minimumCardPickup(int[] cards) {
HashMap<Integer,Integer>map=new HashMap<>();
int ans=(int)1e6;
for(int i=0;i<cards.length;i++)
{
    if(map.containsKey(cards[i])==true)
    {
        ans=Math.min(ans,i-map.get(cards[i]));
        map.put(cards[i],i);
    }
    else
    {
        map.put(cards[i],i);
    }
}
if(ans==(int)1e6)return -1;
else
{
    return ans+1;
}
    }
}
 