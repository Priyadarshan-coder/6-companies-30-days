class Solution {
	public boolean isPossible(int[] nums) {

		HashMap<Integer,Integer> avmp = new HashMap<>();
		HashMap<Integer,Integer> vcmp = new HashMap<>();

		for(int i : nums) {
			avmp.put(i, avmp.getOrDefault(i,0)+1);
		}

		for(int i=0;i<nums.length;i++){
			if(avmp.get(nums[i])<=0){
				continue;
			}
			else if(vcmp.getOrDefault(nums[i],0)>0){
				avmp.put(nums[i], avmp.getOrDefault(nums[i],0)-1);
				vcmp.put(nums[i], vcmp.getOrDefault(nums[i],0)-1);
				vcmp.put(nums[i]+1, vcmp.getOrDefault(nums[i]+1,0)+1);
			}
			else if(avmp.getOrDefault(nums[i],0)>0 && avmp.getOrDefault(nums[i]+1,0)>0 && avmp.getOrDefault(nums[i]+2,0)>0){

				avmp.put(nums[i], avmp.getOrDefault(nums[i],0)-1);
				avmp.put(nums[i]+1, avmp.getOrDefault(nums[i]+1,0)-1);
				avmp.put(nums[i]+2, avmp.getOrDefault(nums[i]+2,0)-1);
				vcmp.put(nums[i]+3,vcmp.getOrDefault(nums[i]+3,0)+1);
			}
			else{
				return false;
			}
		}
		return true;
	}
}