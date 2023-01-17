class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num: nums){
          sum+=num;
        }

        if(sum%k !=0){
            return false;
        }
        if (nums.length < k) return false;
        int targetSum = sum/k;
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, targetSum);

    }

    private boolean canPartition(int[] nums, boolean[] visited, int start, int k, int curSum, int targetSum) {
        if (k == 0) return true;
        if (curSum > targetSum) return false;
        if (curSum==targetSum)  {
            return canPartition(nums, visited, 0, k - 1, 0, targetSum);
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (canPartition(nums, visited,i+1, k,curSum+ nums[i], targetSum)) return true;
            visited[i] = false;
        }

        return false;
    }
}