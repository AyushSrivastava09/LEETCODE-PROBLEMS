class Solution {
    public int minInsertions(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans =0;
        for(int i =0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                if(stack.isEmpty() || stack.peek() == 2)
                stack.push(2);
                else{
                    stack.pop();
                    stack.push(2);
                    ans++;
                }
            }
            else if(ch == ')')
            {
                if(stack.isEmpty())
                {
                    stack.push(1);
                    ans++;
                }
                else if (stack.peek()==1)
                stack.pop();
                else if (stack.peek()==2)
                {
                    stack.pop();
                    stack.push(1);
                }
            }
           
        }
        while(!stack.isEmpty())
        {
            ans = ans + stack.peek();
            stack.pop();
        }
        return ans;
    }
}