// class Solution {
//     public int maxProfit(int[] nums) {
//         int min = nums[0];
        
//         int globalProfit = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] < min) {
//                 min = nums[i];
//             }

//             if (nums[i] > min) {
               
//                 globalProfit = Math.max(globalProfit, nums[i] - min);
//             }
//             return globalProfit;

//         }
//     }

// }

