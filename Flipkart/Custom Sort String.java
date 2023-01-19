class Solution {
    public String customSortString(String order, String s) {
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(char ch : order.toCharArray()){
            if(map.containsKey(ch)){
                for(int i = 0; i < map.get(ch); i++){
                    ans.append(ch);
                }
                map.remove(ch);
            }
        }
        for(char ch : map.keySet()){
            for(int i = 0; i < map.get(ch); i++){
                    ans.append(ch);
                }
        }
        return ans.toString();
    }
}