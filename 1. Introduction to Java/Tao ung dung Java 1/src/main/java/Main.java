import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println("Xin chao moi nguoi");
        int bien = 10;
        float bien1 = (float) 10.7;
        String bien2 = "Hello World";
        bien++;
        System.out.println("Xin Chao :"+bien);
        System.out.println("Xin Chao :"+bien1);
        System.out.println("Xin Chao :"+bien2);
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap number 1:");
        int number1 = input.nextInt();
        System.out.println("Nhap number 2:");
        int	number2		=	input.nextInt();
        System.out.println("Result:");
        int	expectedAnswer	=	input.nextInt();
        while	(number1	+	number2	!=	expectedAnswer)	{
            System.out.println("Wrong	answer");
            System.out.println("Result:");
            expectedAnswer	=	input.nextInt();
        }
        System.out.println("You	got	it!");
    }
}
