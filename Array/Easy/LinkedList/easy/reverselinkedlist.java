import java.util.* ;
// this is an update that i am making in my code
class main{
    static class Node{
        int data;
        Node next;
        Node( int x){
            data=x;
            next=null;
        }
    }
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int [] nums= new int[n];
        for (int i=0;i<nums.length;i++){
            nums[i]= sc.nextInt();
        }      
        Node head =arrll(nums);
        Node result = reverse(head);
        Node temp= result;
        while (temp!= null){
            System.out.print(temp.data + " ");
            temp= temp.next;
        }  

    }
    // converting the array to linked list
    public static Node arrll(int [] nums){
        if (nums.length==0){
            return null;
        }
        Node head = new Node (nums[0]);
        Node curr= head;
        for (int i =1;i<nums.length;i++){
            
            curr.next= new Node(nums[i]);
            curr= curr.next;
        }
        return head;
    }
    public static Node reverse (Node head){
        Node prev= null;
        Node curr= head;
        while (curr!= null){
            Node next= curr.next;
            curr.next= prev;
            prev= curr;
            curr= next;


        }
        return prev;

    }
}