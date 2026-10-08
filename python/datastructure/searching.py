class Pearson:

    def __init__(self, name, number):
        self.name = name
        self.number = number

    @staticmethod
    def linearSearch(people, target):
        for person in people:
            if target == person.name:
                return person.number
        return -1


# main

people = [
    Pearson("sania", "9099387373"),
    Pearson("ali", "9876543210"),
    Pearson("fatima", "9123456789")
]

target = input("Enter the name: ").lower()

result = Pearson.linearSearch(people, target)

print(result)