class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set= new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        int result =0;
        for(int num: set){
            if(num>0) result+=num;
        }
        if(result ==0){
            result=Collections.max(set);
        }
        return result;
        
    }
}