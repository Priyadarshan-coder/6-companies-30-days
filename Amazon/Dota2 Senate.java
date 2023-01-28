class Solution {
    public String predictPartyVictory(String senate) {
     int n = senate.length();
        Queue<Integer> qR =new LinkedList<>(); 
        Queue<Integer> qD = new LinkedList<>(); 
        for (int i=0; i<n;i++) {
            if (senate.charAt(i)=='R') 
                qR.add(i);
             else 
                qD.add(i);
        }
        while (!qR.isEmpty() && !qD.isEmpty()) {
            int r = qR.poll();
            int d = qD.poll();
            if (r<d) 
                qR.add(r+n);
            else 
                qD.add(d+n);
        }
         if(qR.isEmpty())
         return "Dire" ;
         else
         {
             return "Radiant";
         } 
    }
}