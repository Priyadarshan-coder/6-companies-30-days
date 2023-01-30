class Solution {
    private int helper(String s,Set<String>set)
    {
            int max=0;
        for(int i=1;i<=s.length();i++)
        {
            if(!set.contains(s.substring(0,i)))
            {
                set.add(s.substring(0,i));
                max=Math.max(max,1+helper(s.substring(i),set));
                set.remove(s.substring(0,i));
            }
        }
        return max;
    }
    public int maxUniqueSplit(String s) {
       return  helper(s,new HashSet());
    }
}