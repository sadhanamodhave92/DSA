class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum=sum+nums[i];
        }
        int maxsum = sum;
        int startIndex=0;
        int endIndex = k;
        while(endIndex<nums.length){
             sum=sum-nums[startIndex];
             startIndex++;
             sum=sum+nums[endIndex];
             endIndex++;
             maxsum=Math.max(maxsum,sum);
        }
        return (double) maxsum/k;
    }
}