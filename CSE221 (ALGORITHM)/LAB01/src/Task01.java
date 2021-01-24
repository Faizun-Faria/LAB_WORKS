/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faizun
 */
import java.util.Stack;

public class Task01 {

    static Stack<Integer> stack;

    public static void main(String[] args) {
        stack = new Stack<>();
        push(10);
        push(5);
        push(6);
        pop();
        push(9);
        push(3);
        push(2);
        pop();
        pop();

    }

    public static void push(int i) {
        System.out.println("Pushing " + i);
        stack.push(i);
        printTop();
    }

    public static void printTop() {
        System.out.println("Printing top: ");
        System.out.println(stack.peek());
    }

    public static void pop() {
        System.out.println("Popping " + stack.pop());
        printTop();
    }
}
