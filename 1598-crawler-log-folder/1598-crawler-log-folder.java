class Solution {
    public int minOperations(String[] log) {
      int count=0;
        for(int i=0; i<log.length; i++)
        {
            
            if(!log[i].equals("./") && !log[i].equals("../"))
            {
                count++;
            }
            else if(log[i].equals("./"))
            {
                continue;
            }
            else
            {
                if(count!=0)
                {
                count--;
                }
            }
        }
        if(count<=0)
        {
            return 0;
        }
        return count;
    }
}