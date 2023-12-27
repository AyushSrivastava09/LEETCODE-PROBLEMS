class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) 
    {
        int n=releaseTimes.length;
        int[] prefix = new int[n];
        
        prefix[0] = releaseTimes[0];
        for(int i=1;i<n;i++)
        {
            prefix[i] = releaseTimes[i] - releaseTimes[i-1];
        }
        
        int ans = prefix[0];
        char bestchar = keysPressed.charAt(0);
        for(int i=0;i<n;i++)
        {
            if(ans<prefix[i])
            {
                ans = prefix[i];
                bestchar = keysPressed.charAt(i);
            }
            else if((ans==prefix[i]) && (keysPressed.charAt(i) > bestchar))
            {
                bestchar = keysPressed.charAt(i);
            }
        }
                    
    return bestchar;
        
    }
}