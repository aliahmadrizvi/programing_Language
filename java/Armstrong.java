
import java.util.Scanner;
class Armstrong {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int num = inp.nextInt();
        int last , ans =0,temp=num;
        while(temp>0){
            last = temp%10;
            ans = ans + (last*last*last);
            temp=temp/10;
        }
        if(ans == num){
            System.out.println("Armstrong ");

        }
        else{
            System.out.println("Not an Armstrong ");
        }
    }
}