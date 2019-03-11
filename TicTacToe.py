import re                                   #import regular expression to create input pattern

def printGameArena(GameArena):              # print tic tac toe table
    for row in range(3):
        for col in range(3):
            print(GameArena[row][col],end=' ')
        print('\n')

def isValid():                              # Checks weather user input is valid. this can be done multiple ways but pattern was a pretty short compared to try catch
    pattern = '\s*[0-2]\s*,\s*[0-2]\s*$'
    while(True):
        coordinate = input('$> ')
        Validate = re.match(pattern,coordinate)
        if Validate is not None:
            return coordinate.replace('\\s+','')
        else:
            print("Invalid Input: Please input valid integer coordinate positions seperated by a comma\n" +
                  "Coordinate position begin at 0,0 and ends at 2,2 \n" +
                  "Example of a valid coordinate position: 0,1\n\n")


def DetermineWin(row,col,GameArena):                               # checks weather a win has occurred and only checks the neccary row and col along with dioginal checks
    player = GameArena[row][col]
    if player == GameArena[row][0] and player == GameArena[row][1] and player == GameArena[row][2]:
        return True
    if player == GameArena[0][col] and player == GameArena[1][col] and player == GameArena[2][col]:
        return True
    if player == GameArena[0][0] and player == GameArena[1][1] and player == GameArena[2][2]:
        return True
    if player == GameArena[0][2] and player == GameArena[1][1] and player == GameArena[2][0]:
        return True
    return False



def GamePlay():                                                      # Main code that allows the game play.
    print("Let's Play Tic-Tac-Toe!\n")
    GameArena = [['*' for row in range(0,3)] for col in range(0,3)]  # Initialize Tic Tac Toe table
    Players = ['X','0']                                              # Players X and 0
    index = 0                                                        # used to switch between players
    turns = 0                                                        # used to cnt each turn to determine draw and also to check for wins only after a win can occur based on turns
    result = False                                                   # boolean variable. becomes true if a win occurs
    while(True):
        print("Game: In Progress\n")
        printGameArena(GameArena)
        print(Players[index] + ', your Turn\n')
        ROW, COL = isValid().split(',')                              # Validates inputs in another function
        row = int(ROW)
        col = int (COL)
        if GameArena[row][col] == '*':                               # Inputs only if table is empty
            GameArena[row][col] = Players[index]
            if turns >= 4:                                           # Checks for win only after the 4th turn
                result = DetermineWin(row,col,GameArena)             # Checks for wins
                if result == True:
                    print("Game: Won\n")
                    print("\n",Players[index],", Won the Game")
                    break
                if turns >= 8:
                    print("Game: Draw\n")
                    break
            turns +=1                                                 # increment turns
            if index == 0:                                            #Changes players
                index = 1
            else:
                index = 0
        else:
            print("Coordinate taken, Please try again!!!\n")
    print("### Program Terminates ###")









GamePlay()
