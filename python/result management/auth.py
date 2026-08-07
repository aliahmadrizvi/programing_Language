import hashlib
from models import User
from database import Database

class AuthService:
    def __init__(self, db: Database):
        self.db = db

    def register(self, username: str, password: str, role: str = "student") -> User | None:
        if self.db.get_user_by_username(username):
            return None
        hashed_pw = hashlib.sha256(password.encode()).hexdigest()
        user = User(username=username, password=hashed_pw, role=role)
        return self.db.add_user(user)

    def login(self, username: str, password: str) -> User | None:
        user = self.db.get_user_by_username(username)
        if not user:
            return None
        hashed_input = hashlib.sha256(password.encode()).hexdigest()
        if user.password == hashed_input:
            return user
        return None
