package DC;

import java.util.*;
import java.util.stream.Collectors;

public class Tree {

    class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }

    public void inorderRecursion(TreeNode node, List<Integer> list){
        if(node ==null) return;
        inorderRecursion(node.left, list);
        list.add(node.val);
        inorderRecursion(node.right, list);

    }

    public void preorderRecursion(TreeNode node, List<Integer> list){
        if(node ==null) return;
        list.add(node.val);
        preorderRecursion(node.left, list);
        preorderRecursion(node.right, list);
    }

    public void postorderRecursion(TreeNode node, List<Integer> list){
        if(node ==null) return;
        postorderRecursion(node.left, list);
        postorderRecursion(node.right, list);
        list.add(node.val);
    }

    public void inorderIteration(TreeNode node, List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || node !=null){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
    }

    public void preorderIteration(TreeNode node, List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || node !=null){
            while(node!=null){
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
    }

    public void postorderIteration(TreeNode node, List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || node!=null){
            while(node!=null){
            stack.push(node);
            list.add(0, node.val);
            node = node.right;
        }
        node = stack.pop();
        node = node.left;
        }
    }

    public void levelorder(TreeNode node, List<Integer> list){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            node = q.poll();
            list.add(node.val);
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
        }


    }

    public String output(List<Integer> list){
        String output = String.join("," , list.stream().map(item->String.valueOf(item)).collect(Collectors.toList()));

        return output;
    }

    public TreeNode generateTree(int[] nums){
        Queue<TreeNode> q= new LinkedList<>();
        TreeNode node = new TreeNode(nums[0]);
        q.offer(node);
        for(int i=1; i<nums.length; i++){
            TreeNode cur = q.poll();
            cur.left = new TreeNode(nums[i++]);
            cur.right = new TreeNode(nums[i]);
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return node;
    }

    public TreeNode generate(String[] nums){
        Queue<TreeNode> q= new LinkedList<>();
        TreeNode node = nums[0] ==null ? null : new TreeNode(Integer.parseInt(nums[0]));
        if(node!=null) q.offer(node);
        for(int i=1; i<nums.length; ){
            TreeNode cur = q.poll();
            if(nums[i++]!=null) {cur.left = new TreeNode(Integer.parseInt(nums[i-1]));q.offer(cur.left);}
            if(nums[i++]!=null) {cur.right = new TreeNode(Integer.parseInt(nums[i-1]));q.offer(cur.right);}

        }
        return node;
    }

    public static void main(String[] args){
        //int[] nums = {4,2,6,1,3,5,7};
        String[] values = {"1","2","3",null, "4","5", null};
        Tree t = new Tree();
        //TreeNode node = t.generateTree(nums);
        TreeNode node = t.generate(values);
        List<Integer> list = new ArrayList<>();
        t.inorderRecursion(node, list);
        System.out.println(String.format("inorder %s %s", t.output(list), "recursion"));
        list.clear();
        t.inorderIteration(node, list);
        System.out.println(String.format("inorder %s %s", t.output(list), "iteration"));
        list.clear();
        t.preorderRecursion(node, list);
        System.out.println(String.format("preorder %s %s", t.output(list), "recursion"));
        list.clear();
        t.preorderIteration(node, list);
        System.out.println(String.format("preorder %s %s", t.output(list), "iteration"));
        list.clear();
        t.postorderRecursion(node, list);
        System.out.println(String.format("postorder %s %s", t.output(list), "recursion"));
        list.clear();
        t.postorderIteration(node, list);
        System.out.println(String.format("postorder %s %s", t.output(list), "recursion"));
        list.clear();
        t.levelorder(node, list);
        System.out.println(String.format("postorder %s %s", t.output(list), "recursion"));




    }
}
