# Given a list of numbers, return True if first and last number of a list is same.
# Bonus points if you can make the user enter their own list.

# Given list of numbers
numList = [10, 20, 30, 40, 11]
print("Given list is ", numList)

# Get first element in list
firstElement = numList[0]
# Get last element in list
lastElement = numList[-1]

# Check if first and last element are equal
if (firstElement == lastElement):
    print(True)
else:
    print(False)