import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();

        int [] nums= new int[n];
        for (int i =0;i<nums.length;i++){
            nums[i]=sc.nextInt();
        }

        System.out.println(maxProduct(nums));
        sc.close();
    }

    public static int maxProduct(int [] nums){
        int left=1;
        int right =1;
        int n= nums.length;

        int max= nums[0];

        for (int i=1;i<nums.length;i++){
            left*= nums[i];
            right*= nums[n-i-1];

            max= Math.max(max, Math.max(left, right));

            if (left==0){
                left=1;
            } 
            if (right==0){
                right=1;
            }

        }
        return max;
    }
}

