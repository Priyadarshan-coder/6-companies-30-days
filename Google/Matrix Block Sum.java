class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int [][]ans=new int [mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)
            for(int j=0;j<mat[0].length;j++)
            {
                for(int s=Math.max(0,i-k);s<=Math.min(mat.length-1,i+k);s++)
                {
                    for(int l=Math.max(0,j-k);l<=Math.min(mat[0].length-1,j+k);l++)
                    {
                        ans[i][j]+=mat[s][l];
                    }
                }
            }
            return ans;
    }
}