package StackReverse;

import java.util.Scanner;
import java.util.Stack;

public class StackReverse {
    public static void main(String[] args) {
        System.out.print("Input text:");
        Scanner scn = new Scanner(System.in);
        String inputText = scn.nextLine();
        String[] words = inputText.split("[ \n\t\r.,?;:]");
//        -------------------------------------
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < words.length; i++) {
            stack.push(words[i]);
        }
        stack = reverse(stack);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }

    private static Stack<String> reverse(Stack<String> stack) {
        Stack<String> stack1 = new Stack<>();
        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        return stack1;
    }
}
