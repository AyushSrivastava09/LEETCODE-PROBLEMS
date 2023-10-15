class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb= new StringBuilder();
        int size_1=word1.length();
        int size_2=word2.length();
        if(size_1>size_2){
            for(int i=0;i<size_1;i++){
                sb.append(word1.charAt(i));
                if(i<size_2){
                    sb.append(word2.charAt(i));
                }
            }
        }else{
            for(int i=0;i<size_2;i++){
                if(i<size_1){
                    sb.append(word1.charAt(i));
                }
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }
}