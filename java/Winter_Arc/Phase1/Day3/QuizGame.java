package Winter_Arc.Phase1.Day3;

import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args){
        String[] questions = {
                "Who is IronMan? ",
                "What is real name of Spider MAN? ",
                "Natasha is a ? ",
        };
        String[][] answer = {
                {"1.tONY STACK", "2.MICHEAL","3.JOHN","4.sTANK" },
                {"1.PETER PANTER","2.PETER PARKER","3.jOHN WICK","4.SCARLET"},
                {"1.WRESTLER","2.MAGICIAN","3.AGENT","4.TONY'S GF"}
        };
        int[] correctAnswer = {1,2,3};
        int score = 0 ;
        int guess;

        Scanner sc = new Scanner(System.in);
        System.out.println("=====================");
        System.out.println("Welcome to Quiz Game");
        System.out.println("=====================");
        for(int i = 0;i < questions.length;i++){
            System.out.println(questions[i]);
           for(String option : answer[i]){
               System.out.println(option);
           }
            System.out.print("Enter the guess: ");
           guess = sc.nextInt();

           if(guess == correctAnswer[i]){
               score++;
           }
        }
        System.out.printf("You got %d of 3",score);
    }
}
