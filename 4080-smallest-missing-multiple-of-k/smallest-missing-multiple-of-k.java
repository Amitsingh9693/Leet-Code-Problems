class Solution {
    public int missingMultiple(int[] nums, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        for(int i:nums) res.add(i);
        for(int i=1;i<102;i++){
            if(res.contains(k*i)) continue;
            else return (k*i);
        }
        return 0;
    }
}