from dataclasses import dataclass
from typing import Optional

@dataclass
class User:
    id: Optional[int] = None
    username: str = ""
    password: str = ""
    role: str = "student"

@dataclass
class Student:
    id: Optional[int] = None
    user_id: int = 0
    full_name: str = ""
    roll_number: str = ""
    class_name: str = ""

@dataclass
class Result:
    id: Optional[int] = None
    student_id: int = 0
    subject: str = ""
    marks: int = 0
    semester: int = 1
    status: str = "pending"
from dataclasses import dataclass
from typing import Optional

@dataclass
class User:
    id: Optional[int] = None
    username: str = ""
    password: str = ""
    role: str = "student"

@dataclass
class Student:
    id: Optional[int] = None
    user_id: int = 0
    full_name: str = ""
    roll_number: str = ""
    class_name: str = ""

@dataclass
class Result:
    id: Optional[int] = None
    student_id: int = 0
    subject: str = ""
    marks: int = 0
    semester: int = 1
    status: str = "pending"
