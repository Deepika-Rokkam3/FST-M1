# Write a Python program to calculate the sum of all the elements in a list.
# Bonus points if you can make the user enter their own list.

numbers = input("Enter a sequence of comma separated values: ").split(", ")

sum = 0
for number in numbers:
  sum += int(number)

print(sum)