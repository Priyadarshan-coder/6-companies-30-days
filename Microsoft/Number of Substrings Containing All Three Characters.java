class Solution {
    private static void removemap(HashMap<Character,Integer>map,char ch)
    {
        if(map.get(ch)==1)
        {
            map.remove(ch);
        }
        else
        {
            map.put(ch,map.getOrDefault(ch,0)-1);
        }
    }
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer>mapbig=new HashMap<>();
        HashMap<Character,Integer>mapsmall=new HashMap<>();
        int ans=0;
        int sm=-1;
        int big=-1;
        int comm=-1;
        while(true){
        boolean f1=false;
        boolean f2=false;
        boolean f3=false;
        while(big<s.length()-1)
        {
            f1=true;
            big++;
            char ch=s.charAt(big);
            mapbig.put(ch,mapbig.getOrDefault(ch,0)+1);
            if(mapbig.size()==4)
            {
                removemap(mapbig,ch);
                big--;
                break;
            }
        }
        while(sm<big)
        {
            f2=true;
            sm++;
            char ch=s.charAt(sm);
            mapsmall.put(ch,mapsmall.getOrDefault(ch,0)+1);
            if(mapsmall.size()==3)
            {
                removemap(mapsmall,ch);
                sm--;
                break;
            }
        }
        while(comm<sm)
        {
            f3=true;
            if(mapbig.size()==3 && mapsmall.size()==2){
            ans+=big-sm;
            }
            comm++;
            char ch=s.charAt(comm);
            removemap(mapbig,ch);
            removemap(mapsmall,ch);
            if(mapbig.size()<3 || mapsmall.size()<2)
            {
                break;
            }
        }
        if(f1==false && f2==false && f3==false)
        {
            break;
        }
        }
        return ans;
    }
}