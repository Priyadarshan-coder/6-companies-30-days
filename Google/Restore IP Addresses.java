class Solution {
     List<String> res = new ArrayList<>(); 
    public List<String> restoreIpAddresses(String s) {
        restore(s,0,0,"");
        return res;
    }
    private void restore(String s,int i,int par,String ans)
    {
        if(i==s.length() || par==4)
        {
            if(i==s.length() && par==4)
            res.add(ans.substring(0,ans.length()-1));
            return;
        }
        if(i+1<=s.length())
        restore(s,i+1,par+1,ans+s.charAt(i)+".");
        if(i+2<=s.length() && isValid(s.substring(i,i+2)))
         restore(s,i+2,par+1,ans+s.substring(i,i+2)+".");
         if(i+3<=s.length() && isValid(s.substring(i,i+3)))
          restore(s,i+3,par+1,ans+s.substring(i,i+3)+".");
    }
    boolean isValid(String ans)
    {
        if(ans.length()==2)
        {
            if(ans.charAt(0)=='0')return false;
            else
            return true;
        }
        else if(ans.length()==3)
        {
             if(ans.charAt(0)=='0')return false;
             else if(Integer.parseInt(ans)>255)return false;
             else if(Integer.parseInt(ans)<=255 &&Integer.parseInt(ans)>0)return true;
        }
        return false;
    }
}
class Solution {
     List<String> res = new ArrayList<>(); 
    public List<String> restoreIpAddresses(String s) {
        restore(s,0,0,"");
        return res;
    }
    private void restore(String s,int i,int par,String ans)
    {
        if(i==s.length() || par==4)
        {
            if(i==s.length() && par==4)
            res.add(ans.substring(0,ans.length()-1));
            return;
        }
        if(i+1<=s.length())
        restore(s,i+1,par+1,ans+s.charAt(i)+".");
        if(i+2<=s.length() && isValid(s.substring(i,i+2)))
         restore(s,i+2,par+1,ans+s.substring(i,i+2)+".");
         if(i+3<=s.length() && isValid(s.substring(i,i+3)))
          restore(s,i+3,par+1,ans+s.substring(i,i+3)+".");
    }
    boolean isValid(String ans)
    {
        if(ans.length()==2)
        {
            if(ans.charAt(0)=='0')return false;
            else
            return true;
        }
        else if(ans.length()==3)
        {
             if(ans.charAt(0)=='0')return false;
             else if(Integer.parseInt(ans)>255)return false;
             else if(Integer.parseInt(ans)<=255 &&Integer.parseInt(ans)>0)return true;
        }
        return false;
    }
}


       