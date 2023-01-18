class Solution {
    private int game( ArrayList<Integer>list,int k,int ind)
    {
        if(list.size()==1)
        {
            return list.get(0);
        }
        ind=(ind+k)%list.size();
        list.remove(ind);
        return game(list,k,ind);
    }
    public int findTheWinner(int n, int k) {
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            list.add(i);
        }
        return game(list,k-1,0);
    }
}