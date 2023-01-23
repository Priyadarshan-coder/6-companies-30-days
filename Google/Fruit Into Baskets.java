class Solution {
    public int totalFruit(int[] fruits) {
        int i=0,j=0,max=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(i<fruits.length){
            map.put(fruits[i],map.getOrDefault(fruits[i],0)+1);
                while(map.size()>2){
                    map.put(fruits[j],map.get(fruits[j])-1);
                    if(map.get(fruits[j])==0){
                        map.remove(fruits[j]);
                    }
                    j++;
                }
              max=Math.max(max,i-j+1);
            i++;
        }
        return max;
    }
}