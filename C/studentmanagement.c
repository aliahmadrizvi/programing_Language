#include<stdio.h>
int main() {
    printf(
        "STUDENT RESULT MANAGEMENT SYSTEM\n "
        "----------------------------------\n"

    );
    char name[50];
    printf("Enter your full name: ");
    scanf("\n%s", name);
    int roll_no;
    printf("Enter your roll number: ");
    scanf("\n%d", &roll_no);
    int english,maths,chemistry,physics,computer_science;
    printf("Enter marks obtained in English: ");
    scanf("%d", &english);
    printf("Enter marks obtained in Maths: ");
    scanf("%d", &maths);
    printf("Enter marks obtained in Chemistry: ");
    scanf("%d", &chemistry);
    printf("Enter marks obtained in Physics: ");
    scanf("%d", &physics);
    printf("Enter marks obtained in Computer Science: ");
    scanf("%d", &computer_science);
    int total_marks = english + maths + chemistry + physics + computer_science;
    float percentage = (total_marks / 500.0) * 100;
    char grade;
    if (percentage >= 90) {
        grade = 'A';
    } else if (percentage >= 80) {
        grade = 'B';
    } else if (percentage >= 70) {
        grade = 'C';
    } else if (percentage >= 60) {
        grade = 'D';
    } else if (percentage >= 33) {
        grade = 'E';
    
    } else {
        grade = 'F';
    }


    printf("\n-----RESULT-----\n");
    printf("Name: %s\n", name);
    printf("Roll Number: %d\n", roll_no);
    printf("Total Marks: %d / 500\n", total_marks);
    printf("Percentage: %f\n", percentage);
    printf("Grade: %c\n", grade);
    if (percentage >= 33) {
        printf("Status: PASS\n");
        if (percentage >= 75) {
            printf("Congratulations! You have passed with Distinction.\n");
        }
    } else {
        printf("Status: FAIL\n");
        printf("Better luck next time. Work harder!\n");
    }
    return 0;
}