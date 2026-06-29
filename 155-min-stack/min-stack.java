class MinStack {
    Stack<Integer> minstack=new Stack<>();
    Stack<Integer> min=new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int value) {
        minstack.push(value);
        if(min.isEmpty() || value<=min.peek()) min.push(value);
    }
    
    public void pop() {
        if(minstack.peek().equals(min.peek())) min.pop();
        minstack.pop();
    }
    
    public int top() {
        return minstack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */