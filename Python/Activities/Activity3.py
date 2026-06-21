# Make a two-player Rock-Paper-Scissors game.
# Remember the rules:
# Rock beats scissors
# Scissors beats paper
# Paper beats rock


Player1= input("Enter a player1 name:")
Player2= input("Enter a Player2 namer:")

Player1choice = input("pick one from rock, paper and scissor:")
Player2choice = input("pick one from rock, paper and scissor:")

if (Player1choice == Player2choice):
    print("Tie")
elif Player1choice =="rock":
    if Player2choice == "scissor":
       print("rock wins")
    else:
       print("paper wins")

elif Player1choice == "paper":
    if Player2choice == "rock":
        print("paper wins")
    else:
        print("scissors wins")    

elif Player1choice == "scissor":
    if Player2choice == "paper":
        print("scissor wins")
    else:
        print("rock wins")

else:
    print("Invalid input")      

     



    




          



