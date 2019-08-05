package DC;

import java.util.*;
import java.util.stream.Collectors;

public class Tree {

    public static class TreeNode{
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;
        public TreeNode(int val){
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

    public void levelTraversal(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            root = q.poll();
            if(root!=null){
                q.offer(root.left);
                q.offer(root.right);
                System.out.print(root.val);
            }else{
                System.out.print("null");
            }
        }

    }
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public void verticalTraversal(TreeNode root, int level){
        // node(level)->parent(level-1)->leftchild(level-10->rightchild(level+1)
        if(root==null) return;
        if(map.containsKey(level)){
            List<Integer> list = map.get(level);
            list.add(root.val);
            map.put(level, list);
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(level, list);
        }
        verticalTraversal(root.left, level-1);
        verticalTraversal(root.right, level+1);


    }

    public TreeNode generateFromPostPre(){
        //pre root-left- right  in  left-root-right
        //TreeNode root = new TreeNode(pre[0]);
        int[] inorder = {2,4,1,5,3};
        int[] preorder = {1,2,4,3,5};
        List<Integer> inList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        List<Integer> preList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        TreeNode root=helperPostPre(preList, inList, 0, 5, 0, 5);
        levelTraversal(root);
        return root;
    }

    public TreeNode helperPostPre(List<Integer> preList, List<Integer> inList, int ps, int pe, int is, int ie){
        if(ps>=pe || is>=ie) return null;
        TreeNode root = new TreeNode(preList.get(ps));
        int ind = inList.indexOf(root.val);
        List<Integer> leftInList = inList.subList(is, ind);
        int i=ps+1;
        for(; i<pe; i++){
            if(!leftInList.contains(preList.get(i))){
                break;
            }
        }
        root.left = helperPostPre(preList, inList, ps+1, i, is, ind);
        root.right = helperPostPre(preList, inList, i, preList.size(), ind+1, inList.size());
        return root;
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

    public void binaryToDoubleLinkedList(TreeNode root){
        // inorder traversal stack
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() ||  root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            list.add(root);
            root = root.right;

        }
        TreeNode prev = list.get(0);
        TreeNode start = prev;
        for(int i=1; i<list.size(); i++){
            TreeNode curr = list.get(i);
            prev.right = curr;
            curr.left = prev;
            prev = curr;
        }

        while(start!=null){
            System.out.print(start.val);
            start = start.right;
        }

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
        System.out.println(String.format("levelorder %s %s", t.output(list), "recursion"));
        list.clear();
        //TreeNode root = t.generateFromPostPre();

        t.binaryToDoubleLinkedList(node);
        //t.levelorder(root, list);
        //System.out.println(String.format("postorder %s %s", t.output(list), "recursion"));



    }
}
