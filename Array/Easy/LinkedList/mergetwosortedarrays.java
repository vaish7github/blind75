import java.util.*;
class main{
    static class Node{
        int data;
        Node next;
        Node(int x){
            data= x;
            next= null;
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner (System.in);
        int n= sc.nextInt();
        int[] nums1= new int[n];
        for (int i=0;i<nums1.length;i++){
            nums1[i]= sc.nextInt();
        }
        int[] nums2= new int[n];
        for (int i=0;i<nums2.length;i++){
            nums2[i]= sc.nextInt();
        }
        sc.close();

        Node list1= arrtoll(nums1);
        Node list2= arrtoll(nums2);
        Node result = mergeNode(list1, list2);
        Node temp= result;
        while (temp!= null){
            System.out.print(temp.data+ " ");
            temp= temp.next;
        }

    }
    public static Node arrtoll(int [] nums){
        if (nums.length==0){
            return null;
        }
        Node head = new Node(nums[0]);
        Node curr= head;
        for (int i=1;i< nums.length;i++){
            curr.next = new Node(nums[i]);
            curr= curr.next;
        }
        return head;
    }
    public static Node mergeNode(Node list1, Node list2){
        if (list1== null){
            return list2;
        }
        if (list2== null){
            return list1;
        }
        if (list1!= null && list2!=null){
            if (list1.data<list2.data){
                list1.next= mergeNode(list1.next,list2);
                return list1;
            } else {
                list2.next= mergeNode(list1, list2.next);
                return list2;
            }
        }
        return list1;

    }
}