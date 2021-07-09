package Algorithm;

import java.util.Stack;

class CQueue {

    Stack s1;
    Stack s2;

    public CQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if(s2.isEmpty()){
            if(s1.isEmpty())
                return -1;
            else{
                move(s1, s2);
                return (int) s2.pop();
            }
        }
        else{
            return (int) s2.pop();
        }
    }

    public static void move(Stack s1, Stack s2){
        while(!s1.isEmpty()){
            int temp = (int) s1.pop();
            s2.push(temp);
        }
    }
}
