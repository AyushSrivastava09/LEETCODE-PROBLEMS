class Solution {
    public int minOperationsMaxProfit(int[] cus, int board, int run) {
        if(4*board<run)return -1;
        int ans=0,max=0,ro=0,anro=0;
        for(int i=0;i<cus.length-1;i++)
        {
            int t=cus[i];
            if(t>4){cus[i+1]+=cus[i]-4;cus[i]=4;}
            ans+=(cus[i]*board)-(run);
            int o=max;ro++;
            max=Math.max(max,ans);
            if(o!=max){anro=ro;}
            
        }
        System.out.print(anro);
        int h=cus[cus.length-1];
if(h>0)
{
    int j=h/4;
    if((h%4)==0){ans+=(4*j*board)-(j*run);ro+=j;if(ans>max){anro=ro;}}
    else{
        if(h<4){ans+=(h*board)-(run);ro++;if(ans>max){anro=ro;}}
        else{
            ans+=(4*j*board)-(j*run);
            ro+=j;if(ans>max){anro=ro;}
            int g=h%4;
            ans+=(g*board)-run;
            if(((g*board)-run)>0)ro++;
            if(ans>max){anro=ro;}
        }
    }
}

return anro==0?-1:anro;
    }
}