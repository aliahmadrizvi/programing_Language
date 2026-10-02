dict = {
    "name":"Ali ahmad Rizvi",
    "age":21,
    "course":"btech",
    "marks":9.05
}

# print(dict)

# for value in dict:
#     print(value)
    
# for key,value in dict.items():
#     print(f"{key} : {value}")

# numbers = [10,20,20,30,40,40,50]
# print(set(numbers))

# students=[
#     {"name":"Ali","marks":90},
#     {"name":"Ahad","marks":78},
#     {"name":"jawad","marks":94}
# ]

# for student in students:
#     if(student["marks"]>=80):
#         print(student["name"])


marks = [80,75,90,85,70]
total = 0
for mark in marks:
    total+=mark
avg = total/len(marks)
print(avg)
    
    