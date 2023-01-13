class Solution {
    public int minMutation(String st, String e, String[] bank) {
        List<String> ban = new ArrayList<String>();
        ban.add(st);
        for(String b : bank) ban.add(b);
        HashSet<String> has = new HashSet<String>();
        has.add(st);
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : ban){
            for(String str : ban){
                if(diff(s,str) == 1){
                    List<String> list = map.getOrDefault(s,new ArrayList<String>());
                    list.add(str);           
                    map.put(s,list);
                }
            }
        }
        Queue<String> q1 = new LinkedList<String>();
        q1.add(st);
        int changes = 0;
        while(!q1.isEmpty()){
            Queue<String> q2 = new LinkedList<String>();
            while(!q1.isEmpty()){
                String s = q1.poll();
                List<String> list = map.getOrDefault(s,new ArrayList<String>());
                for(String str : list)
                    if(!has.contains(str)){
                        q2.add(str);
                        has.add(str);
                        if(str.equals(e)) return changes + 1;
                    }
            }
            changes++;
            q1=q2;
        }
        return -1;
    }
    
    int diff(String s, String str){
        char[] ch1= s.toCharArray();
         char[] ch2= str.toCharArray();
        int diff=0;
        for(int i=0;i<s.length();i++)
            if(ch1[i]!=ch2[i]) diff++;
        return diff;
    }
}