### DAY1-CALORIE COUNTING
# DECLARE NECCESARY VARIABLES
Calorie_sorting=[]
Currentmax=0
Temporaryvalue=0
#IMPORT INPUT
calories=open(r'C:\Users\nmn08547\PycharmProjects\Day1input.txt').read()
#CALORIES CONTAINS ALL THE CALORIES SPLIT BY THE END OF LINE
calories = calories.split('\n')
calories+=' '
#ANYTIME SPACE IS DETECTED, EVALUATE PREVIOUS/NEW SUMMATION
#EVERY TIME SUM OF GROUP EXCEEDS PREVIOUS SUM, CURRENTMAX EQUALS NEW SUM
#APPEND MAXES TO ARRAY(CALORIE_SORTING)
for i in calories:
    if (i=='') or (i==' '):
        Calorie_sorting.append(Temporaryvalue)
        Temporaryvalue=0
    else:
        Temporaryvalue+=int(i)
Calorie_sorting.sort()
print(max(Calorie_sorting))
print(sum(Calorie_sorting[(len(Calorie_sorting)-3):]))
#FROM ARRAY THAT STORED MAXES, SUM UP THE THREE HIGHEST VALUES


            
