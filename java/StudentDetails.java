import java.util.*;

class Student {
    String name;
    int marks;

    void input(Scanner sc) {
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your marks: ");
        marks = sc.nextInt();

    }

    void print() {
        System.out.println(name + ":" + marks);
    }
}

public class StudentDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student students[] = new Student[5];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].input(sc);
        }
        System.out.println("Students Details are\n Name : Marks");
        for (int i = 0; i < students.length; i++) {
            students[i].print();
        }
        sc.close();

    }

}
