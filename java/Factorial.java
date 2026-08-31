
import java.util.Scanner;

class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Num: ");
        int num = sc.nextInt();

        int ans = 1, i = num;
        while (i > 0) {
            ans = ans * i;
            i--;

        }
        System.out.println("Factorial = " + ans);
        sc.close();

    }
}