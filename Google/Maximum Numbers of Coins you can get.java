class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans=0;
        int me=piles.length-2;
        int bob=0;
        while(bob<piles.length/3)
        {
            ans+=piles[me];
            me=me-2;
            bob++;
        }
        return ans;
    }
}