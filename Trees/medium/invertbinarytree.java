import java.util.*;

class main{
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        

        TreeNode(int x){
            data=x;
            left= null;
            right = null;
            
        }
    }
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int[] nums= new int[n];
        for (int i=0;i<nums.length;i++){
            nums[i]= sc.nextInt();
        }

        sc.close();

        TreeNode head = arrtotree(nums);
        TreeNode result = invertatree(head);

        

        // this is how we print the tree
        Queue <TreeNode> queue= new LinkedList<>();
        if (result!= null){
            queue.offer(result);
        }
        while (!queue.isEmpty()){
            int levelsize= queue.size();
            for (int i=0;i<levelsize;i++){
                TreeNode curr= queue.poll();
                System.out.print(curr.data+" ");
                if (curr.left!= null){
                    queue.offer(curr.left);
                }
                if (curr.right!=null){
                    queue.offer(curr.right);
                }

            }
            System.out.println(); // to add line to the tree
        }
    }

    public static TreeNode arrtotree(int[] nums){
        if (nums.length==0){
            return null;
        }

        TreeNode head = new TreeNode(nums[0]);

        Queue<TreeNode> queue= new LinkedList<>();

        queue.offer(head);
        int i=1;
        while (i<nums.length){
            TreeNode current = queue.poll();


            if (i< nums.length){
                current.left= new TreeNode(nums[i++]);
                queue.offer(current.left);
            }
            if (i< nums.length){
                current.right= new TreeNode(nums[i++]);
                queue.offer(current.right);
            }


        }
        return head;
    }

    public static TreeNode invertatree(TreeNode head) {
        inverse(head);
        return head;
    }

    public static void inverse(TreeNode head){
        if (head== null){
            return;
        }

        TreeNode temp = head.left;
        head.left= head.right;
        head.right= temp;

        inverse(head.left);
        inverse(head.right);
    }

}