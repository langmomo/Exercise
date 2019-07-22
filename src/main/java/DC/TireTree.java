package DC;

public class TireTree {

    class TireNode{
        TireNode[] arr;
        boolean isLeaf;
        TireNode(){
            arr = new TireNode[26];
        }
    }
    public int countDistinctSubstring(String str){
        TireNode node= new TireNode();
        for(int j=0; j<str.length(); j++){
            TireNode curr = node;
            for(int i=j; i<str.length(); i++){
                if(curr.arr[str.charAt(i)-'a'] ==null){
                    curr.arr[str.charAt(i)-'a'] = new TireNode();
                }
                curr = curr.arr[str.charAt(i)-'a'];

            }
            curr.isLeaf = true;
        }



        return traversal(node);
    }

    public int traversal(TireNode node){
        if(node ==null) return 0;
        int total = 0;
        for(int i=0; i<26; i++){
            if(node.arr[i]!=null){
                total+=traversal(node.arr[i]);
                System.out.println(total);
            }
        }
        return 1+total;
    }

    public static void main(String args[])
    {
        String str = "abab";
        TireTree tree = new TireTree();
        System.out.println("Count of distinct substrings is "
                + tree.countDistinctSubstring(str));

    }
}
