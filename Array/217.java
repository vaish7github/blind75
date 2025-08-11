// class Solution {
//     public boolean containsDuplicate(int[] nums){
//         Arrays.sort(nums);
//         for (int i=0;i<nums.length;i++){
//             if (nums[i]==nums[i+1]){
//                 return true;
//             }
//         }
//         return false;
//     }
        
// }


class Solution{
    public static boolean result(int [] nums){
        Map <Intger, Intger> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.contains(nums[i])){
                return true;

            }
            else{
                map.put(nums[i],i);
            } 
        }
    }
}