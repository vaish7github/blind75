class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum= nums[0];
        int maxSum= nums[0];
        for (int i =0;i<nums.length;i++){
            currentSum= Math.max(nums[i], nums[i]+currentSum);
            // why we dont take currentsum becuase nums[i] can be greater than nums[0]
            maxSum= Math.max(maxSum,currentSum);

        }
        return maxSum;
    }
    
}
