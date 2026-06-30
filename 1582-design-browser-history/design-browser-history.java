class Node{
    String str;
    Node prev;
    Node next;

    Node(String str){
        this.str=str;
    }
}

class BrowserHistory {
    Node curr;
    public BrowserHistory(String homepage) {
        curr=new Node(homepage);
    }
    
    public void visit(String url) {
        Node newnode=new Node(url);
        curr.next=newnode;
        newnode.prev=curr;

        curr=newnode;
    }
    
    public String back(int steps) {
        while(steps>0 && curr.prev!=null){
            curr=curr.prev;
            steps--;
        }
        return curr.str;
    }
    
    public String forward(int steps) {
        while(steps>0 && curr.next!=null){
            curr=curr.next;
            steps--;
        }
        return curr.str;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */