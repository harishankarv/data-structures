package linkedlistproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Harishankar on 26-06-2015.
 */
public class IsPalindrome {


    public static boolean isPalindrome(Node head){

        Stack<Integer> stack = new Stack<Integer>();
        Node currentNodeSlow = head;
        Node currentNodeFast = head;

        while(currentNodeFast.next != null && currentNodeFast.next.next != null){
            stack.push(currentNodeSlow.data);
            currentNodeSlow = currentNodeSlow.next;
            currentNodeFast = currentNodeFast.next.next;
        }

        if(currentNodeFast.next != null){
            currentNodeSlow = currentNodeSlow.next;
        }else{
            stack.push(currentNodeSlow.data);
        }

        while(!stack.isEmpty()){
            if(stack.pop() != currentNodeSlow.data){
                return false;
            }
            currentNodeSlow = currentNodeSlow.next;
        }

        return true;


    }



    public static void main(String[] args){

        Node head = new Node(1);
        head.addAtEnd(2);
        head.addAtEnd(1);
/*
        head.addAtEnd(2);
        head.addAtEnd(1);
*/

        System.out.println(isPalindrome(head));
    }
}
