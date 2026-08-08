public class LogicalOperators {
    public static void main(String[] args) {
        boolean IsStudent = true;
        int age = 19;
        System.out.println("Adult & student : " + (IsStudent == true && age >= 18));
        System.out.println("Adult or student : " + (IsStudent == true || age >= 18));
        System.out.println("Not a student : " + (!IsStudent));

    }

}
