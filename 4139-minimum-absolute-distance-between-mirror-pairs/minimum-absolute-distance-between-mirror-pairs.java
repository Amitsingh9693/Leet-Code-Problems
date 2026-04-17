import java.util.*;

class Solution {
    int re(int n){
        int ans = 0;
        while(n > 0){
            ans = ans * 10 + n % 10;
            n /= 10;
        }
        return ans;
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            int rev = re(nums[i]);

            if(!map.containsKey(rev)) continue;

            List<Integer> list = map.get(rev);

            int pos = Collections.binarySearch(list, i);

            if(pos < 0) pos = -(pos + 1); 
            else pos = pos + 1; 

            if(pos < list.size()){
                ans = Math.min(ans, list.get(pos) - i);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}