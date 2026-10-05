# import numpy as np

# numbers = np.array([70,80,90,60])
# print(numbers)
# print(np.mean(numbers))
# print(np.max(numbers))
# print(np.min(numbers))
# print(np.sum(numbers))

import numpy as np
sales = np.array([12000,15000,11000,18000,22000,17000,20000])

print("Total sales: ",np.sum(sales))
print("Hightest sales: ",np.max(sales))
print("Lowest sales: ",np.min(sales))
print("Average sales: ",np.mean(sales))
print("Sales more than 16k: ",sales[sales>16000])