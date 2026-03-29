class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        String s=swap(s1,0,2);
        if(s.equals(s2)) return true;
        s=swap(s1,1,3);
        if(s.equals(s2)) return true;
        s=swap(s1,0,2);
        s=swap(s,1,3);
        if(s.equals(s2)) return true;
        return false;
        
    }
    String swap(String s, int i, int j) {
        char[] arr = s.toCharArray(); 
        
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return new String(arr); 
    }
}