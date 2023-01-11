class Solution {
    public String fractionToDecimal(int n, int d) {
      HashMap<Long,Long> map = new HashMap();
        StringBuilder sb = new StringBuilder();
        boolean neg = false;
        long num = n;
        long den  = d;
        if(num<0||den<0) neg = true;
        if(num<0&&den<0) neg = false;
        if(num==0) neg = false;
        num = Math.abs(num);
        den  = Math.abs(den);
        long q = num/den;
        sb.append(q);
        long r = num%den;
        
        if(r==0)
         {
            if(neg)
            {
                sb.insert(0,"-");
            }
             return sb.toString();
        } 
        else{
            sb.append(".");
        }
            while(r!=0)
            {
                if(map.containsKey(r)){
                    long pos = map.get(r);
                    sb.insert((int)pos,"(");
                    sb.append(")");
                    break;
                }
                else{
                map.put(r,(long)sb.length());
                r*=10;
                q = r/den;
                r = r%den;
                sb.append(q);
                }
            }
         if(neg){
           sb.insert(0,"-");
             }
            return sb.toString();
        }
}