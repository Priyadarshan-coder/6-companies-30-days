class Solution {
    private static int hcf(int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        return hcf(b,a%b);
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        int l1=numsDivide[0];
        for(int i=1;i<numsDivide.length;i++)
        {
            l1=hcf(l1,numsDivide[i]);
        }
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            if(l1%nums[i]!=0)
            {
                ans++;
            }
            else
            {
                break;
            }
        }
        if(ans==nums.length)return -1;
        return ans;
    }
}