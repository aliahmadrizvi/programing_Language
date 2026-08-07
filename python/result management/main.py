from database import Database
from auth import AuthService
from models import User, Student, Result
import sys

class ResultManagementSystem:
    def __init__(self):
        self.db = Database()
        self.auth = AuthService(self.db)
        self.current_user: User | None = None

    def show_main_menu(self):
        print("\n=== Result Management System ===")
        print("1. Login")
        print("2. Register")
        print("3. Exit")

    def show_user_menu(self):
        user = self.current_user
        if not user:
            return
        print(f"\n=== Welcome {user.username} ({user.role.capitalize()}) ===")
        print("1. View Profile")
        if user.role == "student":
            print("2. View Results")
        elif user.role == "teacher":
            print("2. Enter Results")
            print("3. View All Results")
        elif user.role == "admin":
            print("2. Manage Users")
            print("3. Manage Students")
        print("4. Logout")

    def run(self):
        while True:
            if not self.current_user:
                self.show_main_menu()
                choice = input("Choose an option: ").strip()
                if choice == '1':
                    self.handle_login()
                elif choice == '2':
                    self.handle_register()
                elif choice == '3':
                    print("Exiting system.")
                    sys.exit()
                else:
                    print("Invalid choice, please try again.")
            else:
                self.show_user_menu()
                choice = input("Choose an option: ").strip()
                self.handle_user_choice(choice)

    def handle_login(self):
        username = input("Enter username: ").strip()
        password = input("Enter password: ").strip()
        user = self.auth.login(username, password)
        if user:
            self.current_user = user
            print(f"\nLogin successful! Welcome {user.username} ({user.role.capitalize()})")
        else:
            print("Login failed. Check username and password.")

    def handle_register(self):
        username = input("Choose username: ").strip()
        password = input("Choose password: ").strip()
        role = input("Enter role (student/teacher/admin): ").strip().lower()
        if role not in ['student', 'teacher', 'admin']:
            print("Invalid role. Must be 'student', 'teacher', or 'admin'.")
            return
        if self.auth.register(username, password, role):
            print("Registration successful! You can now log in.")
            # For students, create a profile after registration
            if role == "student":
                self.current_user = self.auth.login(username, password)
                self.handle_create_student_profile()
                self.current_user = None
        else:
            print("Username already exists. Please choose a different username.")

    def handle_create_student_profile(self):
        print("\n--- Create Student Profile ---")
        full_name = input("Full name: ").strip()
        roll_number = input("Roll number: ").strip()
        class_name = input("Class name: ").strip()
        student = Student(user_id=self.current_user.id, full_name=full_name, roll_number=roll_number, class_name=class_name)
        created = self.db.add_student(student)
        if created:
            print("Student profile created successfully!")
        else:
            print("Failed to create student profile. Roll number might already exist.")

    def handle_user_choice(self, choice):
        user = self.current_user
        if choice == '1':
            self.view_profile()
        elif choice == '2':
            if user.role == "student":
                self.handle_view_results()
            elif user.role == "teacher":
                self.handle_enter_results()
            elif user.role == "admin":
                self.handle_manage_users()
        elif choice == '3':
            if user.role == "teacher":
                self.handle_view_all_results()
            elif user.role == "admin":
                self.handle_manage_students()
            else:
                print("Invalid choice. Please try again.")
        elif choice == '4':
            print("Logging out...")
            self.current_user = None
        else:
            print("Invalid choice. Please try again.")

    def view_profile(self):
        user = self.current_user
        print(f"\n--- Profile for {user.username} ---")
        print(f"Role: {user.role.capitalize()}")
        if user.role == "student":
            student = self.db.get_student_by_user_id(user.id)
            if student:
                print(f"Full Name: {student.full_name}")
                print(f"Roll Number: {student.roll_number}")
                print(f"Class: {student.class_name}")
            else:
                print("Student profile not found.")

    def handle_view_results(self):
        student = self.db.get_student_by_user_id(self.current_user.id)
        if not student:
            print("No student profile found. Please contact admin.")
            return
        results = self.db.get_results_by_student_id(student.id)
        if not results:
            print("No results found.")
            return
        print("\n--- Your Results ---")
        for r in results:
            print(f"Subject: {r.subject}, Marks: {r.marks}, Semester: {r.semester}, Status: {r.status}")

    def handle_enter_results(self):
        print("\n--- Enter Results ---")
        roll_number = input("Enter student's roll number: ").strip()
        # Find student by roll_number
        students = self.db.get_all_students()
        student = next((s for s in students if s.roll_number == roll_number), None)
        if not student:
            print("Student not found.")
            return
        subject = input("Enter subject: ").strip()
        marks_str = input("Enter marks (number): ").strip()
        semester_str = input("Enter semester (number): ").strip()
        try:
            marks = int(marks_str)
            semester = int(semester_str)
        except ValueError:
            print("Invalid number for marks or semester.")
            return
        result = Result(student_id=student.id, subject=subject, marks=marks, semester=semester, status='recorded')
        created = self.db.add_result(result)
        if created:
            print("Result recorded successfully.")
        else:
            print("Failed to record result.")

    def handle_view_all_results(self):
        print("\n--- All Students Results ---")
        results = self.db.get_all_results()
        if not results:
            print("No results found.")
            return
        for r in results:
            student = self.db.get_student_by_id(r.student_id)
            student_info = f"{student.full_name} ({student.roll_number})" if student else "Unknown student"
            print(f"Student: {student_info} | Subject: {r.subject} | Marks: {r.marks} | Semester: {r.semester} | Status: {r.status}")

    def handle_manage_users(self):
        print("\n--- Manage Users ---")
        users = self.db.get_all_users()
        for u in users:
            print(f"ID: {u.id} | Username: {u.username} | Role: {u.role}")
        choice = input("Enter user ID to delete or press Enter to go back: ").strip()
        if choice:
            try:
                user_id = int(choice)
                if self.db.delete_user(user_id):
                    print("User deleted successfully.")
                else:
                    print("User not found or could not be deleted.")
            except ValueError:
                print("Invalid user ID.")

    def handle_manage_students(self):
        print("\n--- Manage Students ---")
        students = self.db.get_all_students()
        for s in students:
            print(f"ID: {s.id} | Name: {s.full_name} | Roll: {s.roll_number} | Class: {s.class_name}")
        choice = input("Enter student ID to delete or press Enter to go back: ").strip()
        if choice:
            try:
                student_id = int(choice)
                if self.db.delete_student(student_id):
                    print("Student deleted successfully.")
                else:
                    print("Student not found or could not be deleted.")
            except ValueError:
                print("Invalid student ID.")

if __name__ == "__main__":
    app = ResultManagementSystem()
    app.run()
