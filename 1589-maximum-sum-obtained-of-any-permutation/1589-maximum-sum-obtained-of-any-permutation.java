class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        Arrays.sort(nums);
        int[] mostFrequentNumbers = getMostFrequentNumbers(requests, nums.length);
        return getTopNumbersByReference(nums, mostFrequentNumbers);
    }

    private int getTopNumbersByReference(int[] nums, int[] intervalRelevance) {
        long sum = 0L;
        for (int j = intervalRelevance.length -1, i = nums.length -1; j >=0 && intervalRelevance[j] > 0; j--) {
            sum += (long) nums[i] * intervalRelevance[j];
            i--;
        }
        return (int) (sum % 1_000_000_007);
    }

    private int[] getMostFrequentNumbers(int[][] requests, int n) {
        int[] mostFrequent =  new int[n+1];
        for (int[] request : requests) {
            mostFrequent[request[0]]++;
            mostFrequent[request[1]+1]--;
        }

        int bonus = 0;
        for (int i = 0; i < mostFrequent.length; i++) {
            bonus += mostFrequent[i];
            mostFrequent[i] = bonus;
        }

        Arrays.sort(mostFrequent);
        return mostFrequent;
    }
}