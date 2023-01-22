class Solution {

	public int maximumGood(int[][] statements) {
		int n= statements.length;
		int maxGoodPersons= 0;
		int combos = 1<<n;

		int[] roles= new int[n];
		for(int mask=1; mask<combos; mask++){
			int currentGoodPersons= apply(roles, mask);
			if(valid(statements, roles))
				maxGoodPersons= Math.max(maxGoodPersons, currentGoodPersons);
		}
		return maxGoodPersons;
	}

	private int apply(int[] roles, int mask){
		int count= 0;
		int n = roles.length;
		for(int i=0; i<n; i++){
			count+= roles[i]= mask&1;
			mask>>=1;
		}
		return count;
	}

	private boolean valid(int[][] statements, int[] roles){
		int n= statements.length;
		for(int i=0; i<n; i++){
			if(roles[i]==0) continue;

			for(int j=0; j<n; j++){
				if(statements[i][j]==2) continue;
				if(statements[i][j]!=roles[j]) return false;
			}
		}
		return true;
	}
}