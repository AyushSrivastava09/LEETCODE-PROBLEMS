class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        // Initialize variables to track the maximum position of ants moving left and the minimum position of ants moving right.
        int leftMax = Integer.MIN_VALUE;
        int rightMin = Integer.MAX_VALUE;
        
        // Find the maximum position of ants moving left.
        for (int i = 0; i < left.length; i++) {
            if (leftMax < left[i]) {
                leftMax = left[i];
            }
        }
        
        // Find the minimum position of ants moving right.
        for (int i = 0; i < right.length; i++) {
            if (rightMin > right[i]) {
                rightMin = right[i];
            }
        }
        
        // Calculate the moment when the last ant(s) fall out of the plank.
        return Math.max(leftMax, n - rightMin);
    }
}