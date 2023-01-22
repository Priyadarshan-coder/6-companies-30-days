class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
        }
        int idx=0;
        while(!pq.isEmpty())
        {
            nums[idx]=pq.poll();
            idx++;
        }
        return nums;
    }
}