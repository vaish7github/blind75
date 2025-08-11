import java.util.*;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int x){
        val=x;
        left= null;
        right=null;
    }
}

public class Main{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int[] nodes= new int[n];

        for (int i=0;i<n;i++){
            nodes[i]=sc.nextInt();
        }
        TreeNode root= buildTree(nodes);
        inorder(root);
    }
    public static void inorder(TreeNode root){
        if (root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val +" " );
        inorder(root.right);
    }

    public static TreeNode buildTree (int [] nodes){
        if (nodes.length==0){
            return null;

        }
        TreeNode root =
    }
}