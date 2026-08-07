import sqlite3
from models import User, Student, Result

class Database:
    def __init__(self, db_name='results.db'):
        self.db_name = db_name
        self._initialize_db()

    def _initialize_db(self):
        with sqlite3.connect(self.db_name) as conn:
            cursor = conn.cursor()
            cursor.execute("""
            CREATE TABLE IF NOT EXISTS user (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT UNIQUE NOT NULL,
                password TEXT NOT NULL,
                role TEXT CHECK(role IN ('admin', 'teacher', 'student')) NOT NULL,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            )
            """)
            cursor.execute("""
            CREATE TABLE IF NOT EXISTS student (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                user_id INTEGER NOT NULL,
                full_name TEXT NOT NULL,
                roll_number TEXT UNIQUE NOT NULL,
                class_name TEXT NOT NULL,
                FOREIGN KEY(user_id) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE
            )
            """)
            cursor.execute("""
            CREATE TABLE IF NOT EXISTS result (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                student_id INTEGER NOT NULL,
                subject TEXT NOT NULL,
                marks INTEGER NOT NULL DEFAULT 0,
                semester INTEGER NOT NULL DEFAULT 1,
                status TEXT NOT NULL DEFAULT 'pending',
                recorded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                FOREIGN KEY(student_id) REFERENCES student(id) ON DELETE CASCADE ON UPDATE CASCADE
            )
            """)

    # User operations
    def get_user_by_username(self, username) -> User | None:
        with sqlite3.connect(self.db_name) as conn:
            cursor = conn.cursor()
            cursor.execute("SELECT id, username, password, role FROM user WHERE username = ?", (username,))
            row = cursor.fetchone()
            if row:
                return User(id=row[0], username=row[1], password=row[2], role=row[3])
        return None

    def add_user(self, user: User) -> User | None:
        with sqlite3.connect(self.db_name) as conn:
            cursor = conn.cursor()
            try:
                cursor.execute("INSERT INTO user (username, password, role) VALUES (?, ?, ?)",
                               (user.username, user.password, user.role))
                conn.commit()
                user.id = cursor.lastrowid
                return user
            except sqlite3.IntegrityError:
                return None

    # Student operations
    def add_student(self, student: Student) -> Student | None:
        with sqlite3.connect(self.db_name) as conn:
            cursor = conn.cursor()
            try:
                cursor.execute(
                    "INSERT INTO student (user_id, full_name, roll_number, class_name) VALUES (?, ?, ?, ?)",
                    (student.user_id, student.full_name, student.roll_number, student.class_name)
                )
                conn.commit()
                student.id = cursor.lastrowid
                return student
            except sqlite3.IntegrityError:
                return None

    def get_student_by_user_id(self, user_id) -> Student | None:
        with sqlite3.connect(self.db_name) as conn:
            cursor = conn.cursor()
            cursor.execute("SELECT id, user_id, full_name, roll_number, class_name FROM student WHERE user_id = ?", (user_id,))
            row = cursor.fetchone()
            if row:
                return Student(id=row[0], user_id=row[1], full_name=row[2], roll_number=row[3], class_name=row[4])
        return None

    def get_student_by_id(self, student_id) -> Student | None:
        with sqlite3.connect(self.db_name) as conn:
            cursor = conn.cursor()
            cursor.execute("SELECT id, user_id, full_name, roll_number, class_name FROM student WHERE id = ?", (student_id,))
            row = cursor.fetchone()
            if row:
                return Student(id=row[0], user_id=row[1], full_name=row[2], roll_number=row[3], class_name=row[4])
        return None

    def get_all_students(self) -> list[Student]:
        with sqlite3.connect(self.db_name) as conn:
            cursor = conn.cursor()
            cursor.execute("SELECT id, user_id, full_name, roll_number, class_name FROM student")
            rows = cursor.fetchall()
            return [Student(id=r[0], user_id=r[1], full_name=r[2], roll_number=r[3], class_name=r[4]) for r in rows]

    # Result operations
    def add_result(self, result: Result) -> Result | None:
        with sqlite3.connect(self.db_name) as conn:
            cursor = conn.cursor()
            cursor.execute(
                "INSERT INTO result (student_id, subject, marks, semester, status) VALUES (?, ?, ?, ?, ?)",
                (result.student_id, result.subject, result.marks, result.semester, result.status)
            )
            conn.commit()
            result.id = cursor.lastrowid
            return result

    def get_results_by_student_id(self, student_id) -> list[Result]:
        with sqlite3.connect(self.db_name) as conn:
            cursor = conn.cursor()
            cursor.execute("SELECT id, student_id, subject, marks, semester, status FROM result WHERE student_id = ?", (student_id,))
            rows = cursor.fetchall()
            return [Result(id=r[0], student_id=r[1], subject=r[2], marks=r[3], semester=r[4], status=r[5]) for r in rows]

    def get_all_results(self) -> list[Result]:
        with sqlite3.connect(self.db_name) as conn:
            cursor = conn.cursor()
            cursor.execute("SELECT id, student_id, subject, marks, semester, status FROM result")
            rows = cursor.fetchall()
            return [Result(id=r[0], student_id=r[1], subject=r[2], marks=r[3], semester=r[4], status=r[5]) for r in rows]

    # User list for admin
    def get_all_users(self) -> list[User]:
        with sqlite3.connect(self.db_name) as conn:
            cursor = conn.cursor()
            cursor.execute("SELECT id, username, password, role FROM user")
            rows = cursor.fetchall()
            return [User(id=r[0], username=r[1], password=r[2], role=r[3]) for r in rows]

    # Delete user by id
    def delete_user(self, user_id: int) -> bool:
        with sqlite3.connect(self.db_name) as conn:
            cursor = conn.cursor()
            cursor.execute("DELETE FROM user WHERE id = ?", (user_id,))
            conn.commit()
            return cursor.rowcount > 0

    # Delete student by id
    def delete_student(self, student_id: int) -> bool:
        with sqlite3.connect(self.db_name) as conn:
            cursor = conn.cursor()
            cursor.execute("DELETE FROM student WHERE id = ?", (student_id,))
            conn.commit()
            return cursor.rowcount > 0
