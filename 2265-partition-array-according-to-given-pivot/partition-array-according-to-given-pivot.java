class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> grater = new ArrayList<>();
        ArrayList<Integer> less = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot)
                less.add(nums[i]);
            else if (nums[i] > pivot)
                grater.add(nums[i]);
            else
                equal.add(nums[i]);
        }

        less.addAll(equal);
        less.addAll(grater);

        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=less.get(i);
        }
        return ans;
    }
}