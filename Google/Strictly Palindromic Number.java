class Solution {
    public boolean ispal(String n){
        int start = 0;
        int end = n.length()-1;
        while(start<end){
            if(n.charAt(start++)!=n.charAt(end--))
                return false;
        }
        return true;
    }
    public boolean isStrictlyPalindromic(int n) {
        for(int i = 2; i < n-1; i++){
            if(!ispal(Integer.toString(n,i)))
                return false;
        }
        return true;
    }
}