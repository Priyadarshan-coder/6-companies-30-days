class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int []arr=new int [nums.length];
        for(int i=0;i<nums.length;i++)
        {
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        int start=0,end=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==arr[i])
            {
                start++;
            }
            else
            {
                break;
            }
        }
        for(int i=nums.length-1;i>start;i--)
        {
            if(nums[i]==arr[i])
            {
                end++;
            }
            else
            {
                break;
            }
        }
        return (nums.length-start-end);
    }
}