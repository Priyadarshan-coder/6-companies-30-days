class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer>maxprof=new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer A,Integer B)
            {
                return profits[B]-profits[A];
            }
        });
         PriorityQueue<Integer>mincap=new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer A,Integer B)
            {
                return capital[A]-capital[B];
            }
        });
        for(int i=0;i<profits.length;i++)
        {
            mincap.add(i);
        }
        for(int i=0;i<k;i++)
        {
            while(!mincap.isEmpty() && w>=capital[mincap.peek()])
            {
                maxprof.add(mincap.poll());
            }
            if(maxprof.isEmpty())
            {
                break;
            }
            w+=profits[maxprof.poll()];
        }
        return w;
    }
}