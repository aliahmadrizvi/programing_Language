package Winter_Arc.Phase1.Day1;
import java.util.Scanner;

public class Code4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the num1: ");
        int num1 = sc.nextInt();

        System.out.print("Enter the num2: ");
        int num2 = sc.nextInt();

        System.out.println("Addition: " + (num1 + num2));
        System.out.println("Subtraction: " + (num1 - num2));
        System.out.println("Multiplication: " + (num1 * num2));

        if (num2 != 0) {
            System.out.println("Division: " + ((double) num1 / num2));
        } else {
            System.out.println("Division: Cannot divide by zero!");
        }
    }
}
