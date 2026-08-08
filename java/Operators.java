
import java.util.Scanner;

public class Operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your number1: ");
        int oneNum = sc.nextInt();
        System.out.print("Enter your number2: ");
        int twoNum = sc.nextInt();

        System.out.println("Addition: " + (oneNum + twoNum));
        System.out.println("Substration: " + (oneNum - twoNum));
        System.out.println("Multiplication: " + (oneNum * twoNum));
        System.out.println("Division: " + (oneNum / twoNum));
        System.out.println("Remainder: " + (oneNum % twoNum));
        System.out.println("First number greater? " + (oneNum > twoNum));
        System.out.println("Numbers equal? " + (oneNum == twoNum));

        sc.close();

    }
}