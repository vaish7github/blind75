import java.util.*;

class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(kadancefunc(nums));
        sc.close();
    }

    public static int kadancefunc(int[] nums) {
        int currentSum = 0;
        int globalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            globalSum = Math.max(globalSum, currentSum);

        }
        return globalSum;

    }
}


