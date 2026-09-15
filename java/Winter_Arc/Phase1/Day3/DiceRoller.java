package Winter_Arc.Phase1.Day3;


import java.util.Random;
import java.util.Scanner;

public class DiceRoller {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rdm = new Random();
        int numOfDdice;
        int total = 0;
        System.out.print("Enter the num of dice to roll: ");
        numOfDdice = sc.nextInt();

        if(numOfDdice>0){

            for(int i = 0;i<numOfDdice;i++){
                int roll = rdm.nextInt(1,7);
                printdie(roll);
                System.out.println("You rolled: "+ roll);
                total= total + roll;
            }
            System.out.println("Total: "+total);
        }
        else{
            System.out.println("Num of dice must be greater than 0 ");
        }


        sc.close();

    }
    static void printdie(int roll){

        String dice1 = """
                 -------
                |       |
                |   ●   |         
                |       |
                 -------
                """;
        String dice2 = """
                 -------
                | ●     |
                |       |         
                |     ● |
                 -------
                """;

        String dice3 = """
                 -------
                | ●     |
                |   ●   |         
                |     ● |
                 -------
                """;

        String dice4 = """
                 -------
                | ●   ● |
                |       |         
                | ●   ● |
                 -------
                """;

        String dice5 = """
                 -------
                | ●   ● |
                |   ●   |         
                | ●   ● |
                 -------
                """;

        String dice6 = """
                 -------
                | ●   ● |
                | ●   ● |         
                | ●   ● |
                 -------
                """;

        switch (roll){
            case 1-> System.out.println(dice1);
            case 2-> System.out.println(dice2);
            case 3-> System.out.println(dice3);
            case 4-> System.out.println(dice4);
            case 5-> System.out.println(dice5);
            case 6-> System.out.println(dice6);
            default -> System.out.println("invalid Input");
        }



    }
}
