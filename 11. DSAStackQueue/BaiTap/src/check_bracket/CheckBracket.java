package check_bracket;

import java.util.Scanner;
import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        System.out.print("Input Expression:");
        Scanner scn = new Scanner(System.in);
        String inputExpression = scn.nextLine();
//        ---------------------------------
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < inputExpression.length(); i++) {
            stack.add(inputExpression.charAt(i));
        }
        int count = 0;
        String check;
        while (!stack.isEmpty()) {
            check = stack.lastElement().toString();
            if (check.equals("(")) {
                count++;
            } else if (check.equals(")")) {
                count--;
            }
            stack.pop();
        }
        System.out.println("Your Expression is "+(count==0));
    }
}
