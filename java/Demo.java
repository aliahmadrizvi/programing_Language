
import java.util.Scanner;

class Calculator {
    public int add(int x, int y) {
        int result = x + y;
        return result;
    }

}

public class Demo {

    public static void main(String[] args) {
        int num1;
        int num2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number 1: ");
        num1 = sc.nextInt();
        System.out.print("Enter the number 2: ");
        num2 = sc.nextInt();

        Calculator cal = new Calculator();

        int ans = cal.add(num1, num2);
        System.out.println("ans is : " + ans);
        sc.close();

    }
}
