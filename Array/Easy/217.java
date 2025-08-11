import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt(); // this is for the length of my array
        int [] arr= new int[n];
        for (int i =0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println(copy(arr));
        sc.close();

    }
    public static boolean copy(int[] arr){
        int n= arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            if (map.containsKey(arr[i])){
                return true;
            } else {
                map.put(arr[i],i);
            }
        }
        return false;
    }
}