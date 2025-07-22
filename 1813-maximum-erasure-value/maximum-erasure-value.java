import java.util.*;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l = 0, r = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxSum = 0;

        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            sum += nums[r];

            while ((r - l + 1) > map.size()) {
                map.put(nums[l], map.get(nums[l]) - 1);
                sum -= nums[l];
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }

            maxSum = Math.max(maxSum, sum);
            r++;
        }

        return maxSum;
    }
}