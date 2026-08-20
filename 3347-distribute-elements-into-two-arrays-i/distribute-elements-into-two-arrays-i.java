class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        int n=nums.length;
        if(n<=2) return nums;
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i=2;i<n;i++){
            if(arr1.get(arr1.size()-1)>arr2.get(arr2.size()-1)) arr1.add(nums[i]);
            else arr2.add(nums[i]);
        }
        int i=0;
        while(arr1.size()>0){
            nums[i]=arr1.get(0);
            arr1.remove(0);
            i++;
        }
        while(arr2.size()>0){
            nums[i]=arr2.get(0);
            arr2.remove(0);
            i++;
        }
        return nums;
    }
}