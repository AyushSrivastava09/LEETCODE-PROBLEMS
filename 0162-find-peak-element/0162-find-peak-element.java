class Solution {
    public int findPeakElement(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start < end){
            int mid=start+(end-start)/2;
            if(arr[mid] > arr[mid+1]){
                // you are in decreasing part
                // this might be the answer
                //now go to left if there exist any greater value
                end = mid;
            }else{
                //you are in ascending order
                // go to right if there exist greater value
                start = mid+1;
            }
        }
        //at the end start and end are same so
        return start; //or end
    }
}