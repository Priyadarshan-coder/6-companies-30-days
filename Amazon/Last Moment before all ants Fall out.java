class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int leftcoordinate=0;
        int rightcoordinate=Integer.MAX_VALUE;
        for(int i:left)
        leftcoordinate=Math.max(leftcoordinate,i);
        for(int i:right)
        rightcoordinate=Math.min(rightcoordinate,i);
        return Math.max(leftcoordinate,n-rightcoordinate);
    }
}