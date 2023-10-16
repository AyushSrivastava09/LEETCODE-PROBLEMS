class MyStack {
    private Deque<Integer> primary = null, secondary = null;
    public MyStack() {
        primary = new ArrayDeque<>();
        secondary = new ArrayDeque<>();
    }
    
    public void push(int x) {
        primary.offerLast(x);
    }
    
    public int pop() {
        while(primary.size() != 1){
            secondary.offerLast(primary.pollFirst());
        }
        int res = primary.pollFirst();
        while(!secondary.isEmpty()){
            primary.offerLast(secondary.pollFirst());
        }
        return res;
    }
    
    public int top() {
        while(primary.size() != 1){
            secondary.offerLast(primary.pollFirst());
        }
        int res = primary.pollFirst();
        secondary.offerLast(res);
        while(!secondary.isEmpty()){
            primary.offerLast(secondary.pollFirst());
        }
        return res;
    }
    
    public boolean empty() {
        return primary.isEmpty();
    }
}
