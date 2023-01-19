class Solution {
    private int helpermax(int []nums)
    {
        int sum=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            sum=Math.max(sum+nums[i],nums[i]);
            max=Math.max(max,sum);
        }
        return max;
    }
    private int helpermin(int[]nums)
    {
        int sum=nums[0];
        int min=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            sum=Math.min(sum+nums[i],nums[i]);
            min=Math.min(min,sum);
        }
        return min;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int totsum=0;
        for(int i=0;i<nums.length;i++)
        {
            totsum+=nums[i];
        }
        int minsum=helpermin(nums);
        int maxsum=helpermax(nums);
        if(maxsum>0) return Math.max(maxsum,totsum-minsum);
        else
        return maxsum;
    }
}