class Solution {
	public int maxConsecutive(int bottom, int top, int[] special) {
		Arrays.sort(special);
		int st = bottom;
		int ans = 0;
		for(int i=0;i<special.length;i++){
			int floor = special[i];
			int diff = floor-st;
			ans = Math.max(ans, diff);
			st = floor+1;
		}
		ans = Math.max(ans, top-special[special.length-1]);
		return ans;
	}
}