package ConvertDecimalToBinary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.print("Input a Decimal Number:");
        Scanner sc = new Scanner(System.in);
        Long inputNumb = sc.nextLong();
        Stack<Integer> stack = new Stack<>();
        while(inputNumb!=0) {
            if (inputNumb%2 == 0) {
                stack.push(0);
                inputNumb /= 2;
            } else {
                stack.push(1);
                inputNumb = (inputNumb-1)/2;
            }
        }
        System.out.println("Binary");
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }
}
