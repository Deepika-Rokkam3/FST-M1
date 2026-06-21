#Ask the user for a number. 
#Depending on what number they enter, tell them if the number is an even or odd number.

number= int(input("enter a number:"))
mod = number % 2
if mod == 0:
    print("you picked an even number")
else:
    print("you picked an odd number")

#Way-2

# number = int(input("Enter a number: "))

# if number % 2 == 0:
#     print(str(number) + " is an even number")
# else:
#     print(str(number) + " is an odd number")
