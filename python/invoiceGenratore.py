import random
import datetime
import time

print("------------------------Invoice Generation---------------------")
customer_name = input("Enter Customer Name: ")
num_items = int(input("Enter number of items purchased: "))
items = []
for i in range(num_items):
    item_name = input(f"Enter name of item {i+1}: ")
    item_price = float(input(f"Enter price of item {i+1}: "))
    items.append((item_name, item_price))
gst = item_price * 0.18

invoice_number = random.randint(1000, 9999)
current_date = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
total_amount = sum(price for name, price in items)
print("\nGenerating Invoice...\n")
time.sleep(2)
print("--------------------------------------------------------------")
print(f"Invoice Number: {invoice_number}")
print(f"Date: {current_date}")
print(f"Customer Name: {customer_name}")
print("--------------------------------------------------------------")
print("Items Purchased:")
for name, price in items:
    print(f"- {name}: Rs{price:}")
print("--------------------------------------------------------------")

print(f"Total Amount: Rs{total_amount + gst:}")

paid_amount = float(input("Enter amount paid by customer: Rs"))

leftover = (total_amount + gst) - paid_amount

while leftover > 0:
    if leftover > 0:
        additional_payment = float(input(f"Please pay the remaining amount of Rs{leftover:}: Rs"))
        paid_amount += additional_payment
        leftover = (total_amount + gst) - paid_amount
        print(f"Updated Leftover Amount: Rs{leftover:}")
        print("status: Pending Payment")
    else:
        break
print("status: Payment Complete")
    
    





print("--------------------------------------------------------------")
print("Thank you for your purchase!")
print("--------------------------------------------------------------")
