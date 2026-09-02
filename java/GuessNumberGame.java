import java.util.*;

public class GuessNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int random = (int) (Math.random() * 100);
        int save = random;
        System.out.print("Welcome to Guess Number Game\n");
        while (true) {
            System.out.print("Enter the number: ");
            int user = sc.nextInt();
            if (save == user) {
                System.out.println("WON");
                break;
            } else if (save > user) {
                System.out.println("guess again number is big");
            } else {
                System.out.println("guess again number is small");
            }
        }

        sc.close();
    }

}
