class Solution {
    int f(int n){
        int c=0;
        while(n>0){
            c++;
            n/=10;
        }
        return c;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set=new HashSet<>();
        for(int n:arr1){
            while(n>0){
                set.add(n);
                n/=10;
            }
        }
        int ans=0;
        for(int n:arr2){
            int l=f(n);
            while(n>0){
                if(set.contains(n)) ans=Math.max(ans,l);
                n/=10;
                l--;
            }
        }
        return ans;
    }
}