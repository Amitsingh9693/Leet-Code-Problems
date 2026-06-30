class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[i] <= heights[s.peek()])
                s.pop();
            next[i] = s.isEmpty() ? n : s.peek();
            s.add(i);
        }
        s.clear();
        for (int i = 0; i <n; i++) {
            while (!s.isEmpty() && heights[i] <= heights[s.peek()])
                s.pop();
            prev[i] = s.isEmpty() ? -1 : s.peek();
            s.add(i);
        }

        int max=0;

        for(int i=0;i<n;i++){
            int len=heights[i];
            int bre=next[i]-prev[i]-1;

            max=Math.max(max,len*bre);
        }
        return max;
        
    }
}