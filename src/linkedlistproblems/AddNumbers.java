package linkedlistproblems;

/**
 * Created by Harishankar on 24-06-2015.
 */
public class AddNumbers {

    /*
     * Each Node represents a single digit. Numbers are in reverse:
     * the digit at the unit's place is at the head of the list.
     */
    public static Node addNumbersInReverse(Node first, Node second){


        Node currentNodeFirst = first;
        Node currentNodeSecond = second;

        Node answerHead = null;

        int sum = 0;
        int carry = 0;

        while( (currentNodeFirst != null) && (currentNodeSecond != null) ) {

            sum = (currentNodeFirst.data + currentNodeSecond.data + carry) % 10 ;
            carry = (currentNodeFirst.data + currentNodeSecond.data + carry) / 10 ;

            if(answerHead == null){
                answerHead = new Node(sum);
            }else{
                answerHead.addAtEnd(sum);
            }

            currentNodeFirst = currentNodeFirst.next;
            currentNodeSecond = currentNodeSecond.next;
        }

        /*
         * for when one number has more digits than the other
         */

        if(currentNodeFirst != null){

            while(currentNodeFirst != null){
                sum = (currentNodeFirst.data + carry) % 10;
                carry = (currentNodeFirst.data + carry) / 10;
                answerHead.addAtEnd(sum);
                currentNodeFirst = currentNodeFirst.next;
            }

        }else{

            while(currentNodeSecond != null){
                sum = (currentNodeSecond.data + carry) % 10;
                carry = (currentNodeSecond.data + carry) / 10;
                answerHead.addAtEnd(sum);
                currentNodeSecond = currentNodeSecond.next;
            }

        }

        /*
         * If a carry remains after the end of all additions,
         * it means the answer has an additional digit
         */

        if(carry != 0){
            answerHead.addAtEnd(carry);
        }
        return answerHead;

    }

    //------------------------------------------------------------------------------------------------------------------


    /*
     * Numbers are in correct order:
     * the digit at the unit's place is at the end of the list.
     */
    public static Node addNumbers(Node first, Node second){

        Node currentNodeFirst = first;
        Node currentNodeSecond = second;

        Node answerHead = null;
        Node previousAnswer = null;

        int sum = 0;
        int carry = 0;

        /*
         * for when one number has more digits than the other.
         * first find the length of both the lists.
         * if one is greater than the other, pad zeroes
         */

        int lengthFirst = 0;
        int lengthSecond = 0;
        while(currentNodeFirst != null){
            lengthFirst ++;
            currentNodeFirst = currentNodeFirst.next;
        }

        while(currentNodeSecond != null){
            lengthSecond++;
            currentNodeSecond = currentNodeSecond.next;
        }

        int difference = lengthFirst - lengthSecond;
        if(difference > 0){
            while(difference !=0){
                //add 0 at beginning
                Node newHead = new Node(0);
                newHead.next = second;
                second = newHead;

                difference--;
            }
        }else if(difference < 0){
            difference = -difference;
            while(difference !=0){
                //add 0 at beginning
                Node newHead = new Node(0);
                newHead.next = first;
                first = newHead;

                difference--;
            }
        }

        currentNodeFirst = first;
        currentNodeSecond = second;


        /*
         * Now do the same thing as the addNumbersReverse
         */
        while( (currentNodeFirst != null) && (currentNodeSecond != null) ) {

            sum = (currentNodeFirst.data + currentNodeSecond.data) % 10 ;
            carry = (currentNodeFirst.data + currentNodeSecond.data) / 10 ;

            if(answerHead == null){
                answerHead = new Node(sum);
                previousAnswer = answerHead;
            }else{
                answerHead.addAtEnd(sum);
                previousAnswer.data = previousAnswer.data + carry;
                previousAnswer = previousAnswer.next;
            }

            currentNodeFirst = currentNodeFirst.next;
            currentNodeSecond = currentNodeSecond.next;
        }

        if( ( (first.data + second.data) / 10 ) > 0 ){
            Node newAnswerHead = new Node((first.data + second.data) / 10);
            newAnswerHead.next = answerHead;
            answerHead = newAnswerHead;
        }

        return answerHead;

    }

    //------------------------------------------------------------------------------------------------------------------


    public static void main(String[] args){

        Node head1 = new Node(6);
        head1.addAtEnd(8);
        head1.addAtEnd(1);
        head1.addAtEnd(7);
        head1.print();

        Node head2 = new Node(2);
        head2.addAtEnd(9);
        head2.addAtEnd(5);
        head2.print();

        Node head = addNumbers(head1, head2);
        head.print();

        head = addNumbersInReverse(head1, head2);
        head.print();
    }
}
