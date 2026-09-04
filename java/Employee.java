import java.util.Scanner;

class employeeDetail {
    private String name;
    private int id;
    private double salary;

    // setters
    public void setDetails(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getsalary() {
        return salary;
    }

    public void display() {
        System.out.println("Name: " + name.toUpperCase() + "\nId: " + id + "\nSalary: $" + salary);
    }

}

public class Employee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 0;

        System.out.print("Enter number of employee: ");
        size = sc.nextInt();
        sc.nextLine();

        employeeDetail employee[] = new employeeDetail[size];
        for (int i = 0; i < employee.length; i++) {
            String name;
            int id;
            double salary;
            employee[i] = new employeeDetail();
            System.out.print("\nEnter your name " + (i + 1) + ": ");
            name = sc.nextLine();
            System.out.print("\nEnter your id " + (i + 1) + ": ");
            id = sc.nextInt();
            System.out.print("\nEnter your salary " + (i + 1) + ": ");
            salary = sc.nextDouble();
            sc.nextLine();

            employee[i].setDetails(name, id, salary);

        }
        for (int i = 0; i < employee.length; i++) {
            employee[i].display();
        }
        sc.close();
    }

}