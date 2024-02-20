class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length,sum=0;
		for(int i=0; i<n; i++)
			sum+=nums[i];

		return (int)((double)n/2*(1+n)-sum);
    }
}