# PART1
List=[]
List2=[]
Totalpoints=0
file=open(r"C:\Users\nmn08547\PycharmProjects\Day2input.txt").read()
List2=file.split()
FirstColumn=List2[0::2]
SecondColumn=List2[1::2]
# 1 = rock
# 2 = paper
# 3 = scissors
# 0 = loss
# 3 = draw
# 6 = win
# A-X = ROCK
# B-Y = PAPER
# C-Z = SCISSORS
for i in range(0,(len(FirstColumn))):
    if FirstColumn[i]=='A' and SecondColumn[i]=='X':
        Totalpoints=Totalpoints+4
    elif FirstColumn[i]=='A' and SecondColumn[i]=='Y':
        Totalpoints=Totalpoints+8
    elif FirstColumn[i]=='A' and SecondColumn[i]=='Z':
        Totalpoints=Totalpoints+3
    elif FirstColumn[i]=='B' and SecondColumn[i]=='X':
        Totalpoints=Totalpoints+1
    elif FirstColumn[i]=='B' and SecondColumn[i]=='Y':
        Totalpoints=Totalpoints+5
    elif FirstColumn[i]=='B' and SecondColumn[i]=='Z':
        Totalpoints=Totalpoints+9
    elif FirstColumn[i]=='C' and SecondColumn[i]=='X':
        Totalpoints=Totalpoints+7
    elif FirstColumn[i]=='C' and SecondColumn[i]=='Y':
        Totalpoints=Totalpoints+2
    else:
        Totalpoints=Totalpoints+6

# PART2

List=[]
List2=[]
Totalpoints=0
file=open(r"C:\Users\nmn08547\PycharmProjects\Day2input.txt").read()
List2=file.split()
FirstColumn=List2[0::2]
SecondColumn=List2[1::2]
# 1 = rock
# 2 = paper
# 3 = scissors
# 0 = loss
# 3 = draw
# 6 = win
# X = LOSE
# Y = DRAW
# Z = WIN
# A = ROCK
# B = PAPER
# C = SCISSORS
for i in range(0,(len(FirstColumn))):
    if FirstColumn[i]=='A' and SecondColumn[i]=='X':
        Totalpoints=Totalpoints+3
    elif FirstColumn[i]=='A' and SecondColumn[i]=='Y':
        Totalpoints=Totalpoints+4
    elif FirstColumn[i]=='A' and SecondColumn[i]=='Z':
        Totalpoints=Totalpoints+8
    elif FirstColumn[i]=='B' and SecondColumn[i]=='X':
        Totalpoints=Totalpoints+1
    elif FirstColumn[i]=='B' and SecondColumn[i]=='Y':
        Totalpoints=Totalpoints+5
    elif FirstColumn[i]=='B' and SecondColumn[i]=='Z':
        Totalpoints=Totalpoints+9
    elif FirstColumn[i]=='C' and SecondColumn[i]=='X':
        Totalpoints=Totalpoints+2
    elif FirstColumn[i]=='C' and SecondColumn[i]=='Y':
        Totalpoints=Totalpoints+6
    else:
        Totalpoints=Totalpoints+7
print(Totalpoints)
