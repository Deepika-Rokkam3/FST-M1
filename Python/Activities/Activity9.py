# Activity 9
# Given a two list of numbers create a new list such that new list should contain only odd numbers from the first list and even numbers from the second list.

a=[1,2,3,4,5,6]
b=[7,8,9,10,11]

newlist= []

print("first list" , a)
print("second list", b)

for num in a:
    if num %2==0:
       newlist.append(num)

for num in b:
    if num %2!= 0:
        newlist.append(num)

print("result list is:", newlist)  
# print(newlist)             

    