class Solution {
    public String longestPrefix(String s) {
        int n=s.length();
        if(n==1)
        {
            return "";
        }
        long p=31,mod=1000000007,pow=1,ph=0,sh=0;
        int ans=0;
        for(int i=0;i<n-1;i++)
        {
            ph=((ph*p)+(s.charAt(i)-'a'+1))%mod;
            sh=(sh+((s.charAt(n-1-i)-'a'+1)*pow)%mod)%mod;
            pow=(pow*p)%mod;
            if(ph==sh)ans=i+1;
        }
        return s.substring(0,ans);
    }
}