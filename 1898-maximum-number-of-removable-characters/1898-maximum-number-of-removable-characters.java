//accepted binary search
class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int k=0;
        //converting s to character array
        char[] chars=s.toCharArray();

            //applying binary search to reduce time complexity
            int low=0,high=removable.length;
            while(low<=high){
                int mid=(low+high)/2;

                //removing characters by assigning them to #
                for(int i=0;i<mid;i++){
                    chars[removable[i]] = '#';
                }
                StringBuilder str=new StringBuilder(newString(chars));

                //if it's valid subsequence, we increase low to mid+1
                if(isSubsequence(str.toString(),p)){
                    low=mid+1;
                }
                //else reassign all characters back to original string and reduce high=mid-1
                else{
                    for(int i=0;i<mid;i++){
                        chars[removable[i]] = s.charAt(removable[i]);
                    } 
                    high=mid-1;
                }
                }

        // }
        return high;
    }

    //genrating new string after removing characters in removable array
    public String newString(char[] chars){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<chars.length;i++){
            if(chars[i]!='#'){
                str.append(chars[i]);
            }
        }
        return str.toString();
    }

    //checking if p is a subsequence of s or not
    public boolean isSubsequence(String s, String p) {
        int i=0,j=0;
        while(i<p.length() && j<s.length()){
            if(p.charAt(i)==s.charAt(j)){
                i++;
            }
            j++;
        }
        if(i==p.length()){
            return true;
        }
        return false;
    }
}