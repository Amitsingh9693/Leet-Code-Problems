class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        long[] ans = new long[nums.length];
        for (List<Integer> list : map.values()) {
            int n = list.size();
            long[] prefix = new long[n];
            prefix[0] = list.get(0);
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            for (int i = 0; i < n; i++) {
                int idx = list.get(i);
                long left = (long) idx * i - (i > 0 ? prefix[i - 1] : 0);
                long right = (prefix[n - 1] - prefix[i]) - (long) idx * (n - i - 1);

                ans[idx] = left + right;
            }
        }

        return ans;
    }
}