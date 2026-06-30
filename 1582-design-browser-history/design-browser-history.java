class BrowserHistory {
    Stack<String> history=new Stack<>(); 
    Stack<String> trash=new Stack<>(); 
    public BrowserHistory(String homepage) {
        history.add(homepage);
    }
    
    public void visit(String url) {
        history.add(url);
        trash.clear();
    }
    
    public String back(int steps) {
        while(steps!=0 && history.size()>1){
            trash.add(history.pop());
            steps--;
        }
        return history.peek();
    }
    
    public String forward(int steps) {
        while(steps!=0 && trash.size()>=1){
            history.add(trash.pop());
            steps--;
        }
        return history.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */