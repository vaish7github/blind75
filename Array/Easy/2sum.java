import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        int target = sc.nextInt();
        int[] nums = sum2(arr, target);
        System.out.println(Arrays.toString(nums));

    }

    public static int[] sum2(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int compliment = target - arr[i];
            if (map.containsKey(compliment)) {
                return new int[] { map.get(compliment), i };

            } else {
                map.put(arr[i], i);
            }
        }
        return new int[] { -1, -1 };

    }

}
