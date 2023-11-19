### PART 1

file=open(r"C:\Users\nmn08547\PycharmProjects\pythonProject5\Day4.txt").read()
file=file.split('\n')
totalpoints=0

for i in file:
    [equation1,equation2]=i.split(',')
    [x1,y1]=equation1.split('-')
    [x2,y2]=equation2.split('-')
    x1=int(x1)
    y1=int(y1)
    x2=int(x2)
    y2=int(y2)
    if ((x2>=x1 and y2<=y1) or (x1>=x2 and y1<=y2)):
        totalpoints+=1
    else:
        continue
print(totalpoints)

### PART 2

file=open(r"C:\Users\nmn08547\PycharmProjects\pythonProject5\Day4.txt").read()
file=file.split('\n')
totalpoints=0

for i in file:
    [equation1,equation2]=i.split(',')
    [x1,y1]=equation1.split('-')
    [x2,y2]=equation2.split('-')
    x1=int(x1)
    y1=int(y1)
    x2=int(x2)
    y2=int(y2)
    if ((x2>=x1 and y2<=y1) or (x1>=x2 and y1<=y2) or (y1>=x2 and x1<=y2)\
        or (y2>=x1 and x2<=y1)):
        totalpoints+=1
    else:
        continue
print(totalpoints)
