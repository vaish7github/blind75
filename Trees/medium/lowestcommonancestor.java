import java.util.*;

class Main{
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            data= x;
            left= null;
            right =null;
        }   
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int [] nums= new int[n];
        for (int i =0;i< nums.length;i++){
            nums[i]= sc.nextInt();
        }
        
        int [] arr= new int[2];
        for (int i =0;i< arr.length;i++){
            arr[i]= sc.nextInt();
        }
       

        sc.close();

        TreeNode head = arrtotree(nums);
        TreeNode node1 = new TreeNode(arr[0]);
        TreeNode node2 = new TreeNode(arr[1]);
        TreeNode result =lowestCommonAncestor(head, node1, node2);
        TreeNode temp = result;
        System.out.println(temp.data);
        
    }

    public static  TreeNode arrtotree(int[] nums){
        if (nums.length ==0){
            return null;
        }
        Queue<TreeNode> queue= new LinkedList<>();
        TreeNode head = new TreeNode(nums[0]);
        queue.offer(head);
        int i =1;

        while (!queue.isEmpty() && i< nums.length){
            TreeNode curr = queue.poll();


            if (i< nums.length){
                curr.left= new TreeNode(nums[i++]);
                queue.offer(curr.left);
            }
            if (i< nums.length){
                curr.right= new TreeNode(nums[i++]);
                queue.offer(curr.right);
            }

        }
        return head;
    }

    public static TreeNode  lowestCommonAncestor(TreeNode head, TreeNode p, TreeNode q){
        if (p.data>q.data){
            return  lowestCommonAncestor(head, q, p);
        }

        return findLCA(head, p,q);
    }

    public static TreeNode findLCA(TreeNode head , TreeNode low , TreeNode high){
        if (head == null){
            return null;
        }

        if (head.data<low.data){
            return findLCA(head.right, low , high);
        }
        else if (head.data> high.data){
            return findLCA(head.left, low, high);
        } else {
            return head;
        }
    }

}