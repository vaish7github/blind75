import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int [ ] nums= new int[n];
        for (int i=0;i<nums.length;i++){
            nums[i]= sc.nextInt();
        }
        System.out.println(min(nums));
        sc.close();

    }
    public static int min(int [] nums){
        int start=0;
        int end=nums.length-1;

        while (start<=end){
            int mid = start+ (end-start)/2;

            if  (nums[start]<= nums[end]){
                return nums[start];
            } 
            // this is the case where the entire array is sorted and has been rotated n times

            if (nums[mid]>=nums[start]){
                start= mid+1;
            } else {
                mid=end;
            }



            
        } 
        return nums[0];
        
        
    }
}

