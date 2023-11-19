# Get columns into array
file=open(r"C:\Users\nmn08547\PycharmProjects\Day5.txt").read()
file=file.split()
list_of_commands=[]
columns=[['S','L','W'],['J','T','N','Q'],['S','C','H','F','J']
         ,['T','R','M','W','N','G','B'],['T','R','L','S','D','H','Q',
        'B'],['M','J','B','V','F','H','R','L'],['D','W','R','N','J','M'],
         ['B','Z','T','F','H','N','D','J'],['H','L','Q','N','B','F','T']]
# Execute labor commands
#EX: move 1 from 6 to 5: first=value, second=length-value, third=length+value
for i in file:
    list_of_commands.append(int(i))
value=list_of_commands[0::3]
remove_from=list_of_commands[1::3]
add_to=list_of_commands[2::3]
for i in range(0,len(remove_from)):
    remove_from[i]=remove_from[i]-1
    add_to[i]=add_to[i]-1
for i in range(0,len(remove_from)):
    for j in columns[remove_from[i]][(len(columns[remove_from[i]])-value[i]):]:
        columns[add_to[i]].append(j)
    del columns[remove_from[i]][(len(columns[remove_from[i]])-value[i])::]
print(columns)
  
                
                
            
