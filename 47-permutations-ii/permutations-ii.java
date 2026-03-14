class Solution {
    Set<List<Integer>> set=new HashSet<>();
    void f(int[] nums,int idx,List<List<Integer>> ans){
        if(idx==nums.length){
            ArrayList<Integer> list=new ArrayList<>();
            for(int i:nums) list.add(i);
            if(set.contains(list)) return;
            set.add(new ArrayList<>(list));
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            f(nums,idx+1,ans);
            swap(nums,idx,i);
        }
    }
    void swap(int[] arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        f(nums,0,ans);
        return ans;
    }
}