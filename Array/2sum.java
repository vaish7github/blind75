import java.util.*;

class main{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr= new int[n];

        for (int i=0;i<n;i++){
            arr[i]= sc.nextInt();

        }
        int result = sum(arr);
        System.out.println(result);
        sc.close();


    }
    public static int sum(int [] rar){
        rar[0]=0;
        return 1;

    }

}