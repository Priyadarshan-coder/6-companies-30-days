class Solution {
    public boolean increasingTriplet(int[] nums) {
        int f=Integer.MAX_VALUE;
        int s=Integer.MAX_VALUE;
        for(int it:nums)
        {
            if(it<f)
            {
                f=it;
            }
            else if(f<it && it<s)
            {
                s=it;
            }
            else if(it>s)
            {
                return true;
            }
        }
        return false;
    }
}