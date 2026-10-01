# print("Hello class")

# a = int(input("Enter the number: ")) #type casting str to int
# b = int(input("Enter the number: "))
# c = a+b
# print("result: ",c)


# userName1 = input("Enter the name of user1: ")
# userName2 = input("Enter the name of user2: ")

# userMark1 = int(input("Enter the marks of user1: "))
# userMark2 = int(input("Enter the marks of user2: "))

# print("total marks: ",userMark1+userMark2)


user= int(input("Enter the number: "))
if(user%3==0 and user%6==0):
    print("Divisible by both 3 and 6")
elif(user%3==0):
    print("Divible by only 3")
elif(user%6==0):
    print("Divisible by only 6")
else:
    print("not divisible by both")

