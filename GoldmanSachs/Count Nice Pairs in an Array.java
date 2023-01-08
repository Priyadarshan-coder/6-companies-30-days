class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;
         int mod = (int)Math.pow(10,9)+7;
        for (int i=0;i<nums.length;i++) {
            int key =nums[i] - reverse(nums[i]);
             //System.out.println(""+key);
            if (map.containsKey(key)) {
                count += map.get(key);
            }

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return (int)(count%mod);
    }

    public int reverse(int n) {
        int rem=0;
        while(n>0)
        {
            rem=n%10+(rem*10);
            n=n/10;
        }
      //  System.out.println(""+rem/10);
        return rem;
    }
}