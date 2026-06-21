# Given a tuple of numbers, iterate through it and print only those numbers which are divisible by 5

# numbers_tuple=(10, 14, 15, 18, 20, 27, 30)

# e=[]
# for num in numbers_tuple:
#     if num % 5 == 0:
#         e.append(num)

# print(e)        

# Given tuple
num_tuple = (10, 20, 33, 46, 55)
print("Given list is ", num_tuple)

# Print elements that are divisible by 5
print("Elements that are divisible by 5:")
for num in num_tuple:
    if (num % 5 == 0):
        print(num)

