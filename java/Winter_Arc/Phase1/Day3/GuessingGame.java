package Winter_Arc.Phase1.Day3;
import java.util.Random;
import  java.util.Scanner;
public class GuessingGame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rdm = new Random();

        int userNumber = -1;
        int randomNumber = rdm.nextInt(0,100);

        while(true){

            System.out.print("Enter the number: ");
            userNumber = sc.nextInt();
            if(userNumber>randomNumber){
                System.out.println("Too big Number!!!");
            }
            else if(userNumber < randomNumber){
                System.out.println("Too low number :(");
            }
            else{
                System.out.println("\nYou done it ,You Won ");
                break;
            }


        }

        sc.close();

    }
}
