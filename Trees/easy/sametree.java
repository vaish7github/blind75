import java.util.*;
class main{
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
  
        TreeNode(int x){
            data= x;
            left= null;
            right = null;
        }
    }

    public static void main(String [] args){
        Scanner sc= new Scanner (System.in);
        // this will be the length of the first array that will be converted into the first tree

        int n= sc.nextInt();
        int [] nums= new int[n];
        for (int i=0;i<nums.length;i++){
            nums[i]= sc.nextInt();
        }

        // now we will have the second array for the second tree
        int m= sc.nextInt();
        int [] arr= new int[n];
        for (int i=0;i<arr.length;i++){
            arr[i]= sc.nextInt();
        }
        TreeNode t1= arrtotree(nums);
        TreeNode t2= arrtotree(arr);
        Boolean result= isSameTree(t1, t2);
        System.out.println(result);
        sc.close();
    }

    public static TreeNode arrtotree(int [] nums){
        if (nums.length==0){
            return null;
        }
        TreeNode head= new TreeNode(nums[0]);
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(head);
        int i=1;

        while (i< nums.length){
            TreeNode current = queue.poll();

            if (i<nums.length){
                current.left= new TreeNode(nums[i++]);
                queue.offer(current.left);
            }
            if (i<nums.length){
                current.right= new TreeNode(nums[i++]);
                queue.offer(current.right);
            }
            
        }
        return head;

    }
    public static Boolean isSameTree(TreeNode t1, TreeNode t2){
        if (t1== null && t2== null){
            return true;
        }
        if (t1!= null && t2!=null && t1.data== t2.data){
            return isSameTree(t1.left,t2.left) && isSameTree(t1.right,t2.right );
        }
        return false;
    } 

}