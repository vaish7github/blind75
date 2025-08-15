import java.util.*;

class main{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int [] nums= new int[n];
        for (int i =0;i< nums.length;i++){
            nums[i]= sc.nextInt();
        }
        sc.close();
        System.out.println(trap(nums));
    }
    public static int trap(int [] nums){
        int left= 0;
        int right = nums.length -1;
        int rightmax= nums[right];
        int leftmax= nums[left];
        int water =0;
        while (left<right){

            if (leftmax<rightmax){
                left++;
                leftmax= Math.max(leftmax, nums[left]);
                water+= leftmax- nums[left];
            } else {
                right--;
                rightmax= Math.max(rightmax, nums[right]);
                water+= rightmax- nums[right];
            }
        }
        return water;
    }

}