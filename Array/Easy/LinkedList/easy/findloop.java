import java.util.*;
class main {
    static class Node{
        int data;
        Node next;
        Node (int x){
            data= x;
            next= null;
        }
        

    }
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int [] nums= new int[n];
        for (int i=0;i<nums.length;i++){
            nums[i]= sc.nextInt();
        }
        sc.close();

        Node head= (arrtoll(nums));
        Boolean result = isloop(head);
        Boolean temp= result;
        
        System.out.print(temp);
        

    }
    public static Node arrtoll(int [] nums){
        if (nums.length==0){
            return null;
        }
        Node head= new Node(nums[0]);
        Node curr= head;
        for (int i=1;i<nums.length;i++){
            curr.next= new Node(nums[i]);
            curr= curr.next;
        }
        return head;
    }
    public static Boolean isloop(Node head){
        Node fast= head;
        Node slow= head;
        while (fast!=null && fast.next!= null){
            fast= fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

}