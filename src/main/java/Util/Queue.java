package Util;

import java.util.Stack;

public class Queue {
    Stack<Integer> stack;
    Stack<Integer> stack2;
    public Queue(){
        stack = new Stack();
        stack2 = new Stack<>();
    }

    public void offer(int item){
        stack.push(item);
    }

    public int poll(){
        if(stack2.isEmpty()){
            while(!stack.isEmpty())
            stack2.push(stack.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args){
        Queue q = new Queue();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println(q.poll());
        q.offer(4);
        System.out.println(q.poll());

    }
}
