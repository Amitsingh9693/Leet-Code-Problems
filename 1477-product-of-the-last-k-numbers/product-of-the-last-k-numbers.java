class ProductOfNumbers {
    ArrayList list;
    public ProductOfNumbers() {
        list=new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int i=list.size()-1,ans=1;;
        while(i>=0 && k>0){
            ans=ans*(int)list.get(i);
            i--;
            k--;
        }
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */