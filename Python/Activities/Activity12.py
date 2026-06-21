# def sum_numbers(n):
#     if n == 0:          # Base case
#         return 0
#     else:
#         return n + sum_numbers(n - 1)   # Recursive call

# result = sum_numbers(10)
# print(result)

# Define function to calculate sum
def calculateSum(num):
  if num:
    # Recursive function call
    return num + calculateSum(num-1)
  else:
    return 0

# Call calculateSum() function
res = calculateSum(10)

# Print result
print(res)