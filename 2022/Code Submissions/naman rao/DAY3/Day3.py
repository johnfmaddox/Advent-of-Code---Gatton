### FIRST PART

file=open(r"C:\Users\nmn08547\PycharmProjects\Day3.txt").read()
Rucksacks=file.split('\n')
Dictionary={'a':1,'b':2,'c':3,'d':4,'e':5,'f':6,'g':7,'h':8,'i':9,'j':10,'k':11,'l':12,'m':13,'n':14,'o':15,
            'p':16, 'q':17,'r':18,'s':19,'t':20,'u':21,'v':22,'w':23,'x':24,'w':25,'z':26,'A':27,'B':28,'C':29,'D':30,
            'E':31,'F':32,'G':33,'H':34,'I':35,'J':36,'K':37,'L':38,'M':39,'N':40,'O':41,'P':42,'Q':43,'R':44,'S':45,
            'T':46,'U':47,'V':48,'W':49,'X':50,'Y':51,'Z':52}
Value=0
def switch(value):
    return Dictionary.get(value,0)

for rucksack in Rucksacks:
    middle=int((len(rucksack))/2)
    FirstCompartment=rucksack[0:middle]
    SecondCompartment=rucksack[middle::]
    Commonitem=''.join(set(FirstCompartment).intersection(SecondCompartment))
    Value=switch(Commonitem)
    TotalValue+=Value
print(TotalValue)


### SECOND PART


for index in range(0,len(Rucksacks)):
    if ((index+3)<= int((len(Rucksacks)))) and ((index%3)==0):
        EndValue=int((index)+3)
        Group=Rucksacks[index:EndValue]
        [FirstSection,SecondSection,ThirdSection]=Group[:]
        InitialIntersection=''.join(set(FirstSection).intersection(SecondSection))
        FinalIntersection=''.join(set(InitialIntersection).intersection(ThirdSection))
        ItemValue=switch(FinalIntersection)
        Value+=ItemValue
print(Value)
