package panlindrome_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PanlindromeQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Text:");
        String inputText = sc.nextLine();
        inputText = inputText.toLowerCase();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < inputText.length(); i++) {
            queue.add(inputText.charAt(i));
        }
        String str = "";
        while(!queue.isEmpty()) {
            str = queue.remove()+str;
        }
        if (str.equals(inputText)) {
            System.out.println("This is a Palindrome");
        } else {
            System.out.println("This is not a Palindrome");
        }
    }
}
