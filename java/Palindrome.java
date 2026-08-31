
import java.util.Scanner;

class Palindrome {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your number : ");
        int num = sc.nextInt();
        int last, temp = num, rev = 0;
        while (temp > 0) {
            last = temp % 10;
            rev = rev * 10 + last;
            temp = temp / 10;
        }
        if (rev == num) {
            System.out.println("Palindrome number");
        } else {
            System.out.print("not a palindrome ");
        }
        sc.close();
    }
}