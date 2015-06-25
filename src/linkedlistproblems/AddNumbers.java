package linkedlistproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Harishankar on 24-06-2015.
 */
public class AddNumbers {

    public static Node addNumbers(Node first, Node second){

        Node currentNodeFirst = first;
        Node currentNodeSecond = second;

        Node newHead = null;

        int sum = 0;
        int carry = 0;

        while( (currentNodeFirst != null) && (currentNodeSecond != null) ) {

            sum = (currentNodeFirst.data + currentNodeSecond.data + carry) % 10 ;
            carry = (currentNodeFirst.data + currentNodeSecond.data + carry) / 10 ;

            if(newHead == null){
                newHead = new Node(sum);
            }else{
                newHead.addAtEnd(sum);
            }

            currentNodeFirst = currentNodeFirst.next;
            currentNodeSecond = currentNodeSecond.next;
        }


        if(currentNodeFirst != null){

            while(currentNodeFirst != null){
                sum = (currentNodeFirst.data + carry) % 10;
                carry = (currentNodeFirst.data + carry) / 10;
                newHead.addAtEnd(sum);
                currentNodeFirst = currentNodeFirst.next;
            }

        }else{

            while(currentNodeSecond != null){
                sum = (currentNodeSecond.data + carry) % 10;
                carry = (currentNodeSecond.data + carry) / 10;
                newHead.addAtEnd(sum);
                currentNodeSecond = currentNodeSecond.next;
            }
        }

        if(carry != 0){
            newHead.addAtEnd(carry);
        }
        return newHead;


    }


    public static void main(String[] args){

        Node head1 = new Node(7);
        head1.addAtEnd(1);
        head1.addAtEnd(9);
        head1.print();

        Node head2 = new Node(5);
        head2.addAtEnd(9);
        head2.addAtEnd(2);
        head2.addAtEnd(9);
        head2.print();

        Node head = addNumbers(head1, head2);
        head.print();
    }
}
