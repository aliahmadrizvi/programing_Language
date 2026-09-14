package Winter_Arc.Phase1.Day2;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
public class ExtractionInfo {
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    String userEmail;
    String userName;
    String userDomain;
    System.out.print("Enter your Email Address: ");
    userEmail = sc.nextLine();

    userName = userEmail.substring(0,userEmail.indexOf("@")) + + random.nextInt(345,589);
    userDomain = userEmail.substring(userEmail.indexOf("@")+1) ;
        System.out.println("Username: "+userName+"\nDomain: "+userDomain);



    }




}
