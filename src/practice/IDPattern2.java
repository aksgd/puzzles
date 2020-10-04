package practice;

import java.util.Stack;

public class IDPattern2 {

    public static void main(String[] args) {
        new IDPattern2("D").run().print();
    }

    private IDPattern2 run() {
        opColl.push(getNextNumber());
        for(char s: pattern) {
            sequencer(opColl, getNextNumber(), s);
        }
        return this;
    }

    Stack sequencer(Stack<Integer> opColl, int c, char s) {
        int l = opColl.peek();

        if(s == 'D') {
            if(l < c) {
                opColl.pop();
                Character s1 = dStackPop();
                if (s1 == null) {
                    opColl.push(c);
                    opColl.push(l);
                } else {
                    sequencer(opColl, c, s1);
                    opColl.push(l);

                }
                dStackPush(s);
            } else {
                opColl.push(c);
                dStackPush(s);
            }
        } else { /// s == I
            if(l < c) {
                opColl.push(c);
                dStackPush(s);
            } else {
                opColl.pop();
                Character s1 = dStackPop();
                if (s1 == null) {
                    opColl.push(c);
                    opColl.push(l);
                } else {
                    sequencer(opColl, c, s1);
                    opColl.push(l);

                }
                dStackPush(s);
            }
        }
        return opColl;
    }

    IDPattern2(String pattern) { this.pattern = pattern.toCharArray(); }

    int numberIndex = 0;
    int[] numbers = {1,2,3,4,5,6,7,8, 9};
    int getNextNumber() { return numbers[numberIndex++]; }

    Stack<Integer> opColl = new Stack<Integer>();
    char[] pattern;
    Stack<Character> dStack = new Stack<Character>();
    Character dStackPop() {
        return dStack.size() > 0 ? dStack.pop() : null;
    }
    void dStackPush(Character s1) {
        dStack.push(s1);
    }



    void print(){
        System.out.println(opColl );
        System.out.println(dStack );
    }






}
