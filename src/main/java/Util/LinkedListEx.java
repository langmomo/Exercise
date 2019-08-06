package Util;

public class LinkedListEx {
    public class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode swapPairs(ListNode head) {
        //1->2->3->4
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode start = prev;
        while(head !=null && head.next !=null){
            ListNode temp = head.next.next;
            head.next.next = head;
            prev.next = head.next;;
            head.next = temp;
            prev = head;
            head =temp;

        }
        return start.next;

    }

    public ListNode reverseLinkedList(ListNode head){
        ListNode prev=null, curr = head, next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseExe(ListNode root){
        ListNode prev = null, curr=root, next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    public void traversal(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println(" ");
    }

    public ListNode generate(int[] arr){
        ListNode node = new ListNode(-1);
        ListNode head = node;
        for(Integer i: arr){
            node.next = new ListNode(i);
            node = node.next;
        }
        return head.next;
    }

    public void findMid(ListNode root){
        ListNode slow = root;
        ListNode fast = root;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
    }

    public static void main(String[] args){
        LinkedListEx l = new LinkedListEx();
        ListNode head = l.generate(new int[]{1,2,3,4,5,6,7});
        ListNode ordihead = head;
        l.traversal(ordihead);
        ListNode reversehead = head;
        //reversehead = l.reverseLinkedList(reversehead);
        reversehead = l.reverseExe(reversehead);
        l.traversal(reversehead);
        l.findMid(reversehead);


        ListNode head2 = l.generate(new int[]{1,2,3,4,5,6});
        ListNode ex = head2;
        l.findMid(ex);
        ListNode reverse = head2;
        l.traversal(l.reverseExe(reverse));

    }
}
