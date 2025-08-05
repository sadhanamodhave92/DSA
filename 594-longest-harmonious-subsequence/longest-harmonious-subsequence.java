class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        int start=0;
        for(int end=1;end<nums.length;end++){
             while (nums[end] - nums[start] > 1) {
                start++;
            }
            if(nums[end]-nums[start]==1){
                max=Math.max(max,(end-start+1));
            }
        }
        return max;
    }
}