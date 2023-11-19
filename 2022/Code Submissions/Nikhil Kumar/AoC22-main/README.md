# AoC22
Hello welcome to my solutions to Advent of Code 2022. To run the code it requires some special instructions, before getting into that I will explain the directory structure.
When opening up the src folder (the folder where all the crucial contents are) you will see three folders:  
1.) inputs  
2.) javafiles  
3.) utilities  

In the inputs folder you will find all of the inputs for each of the days. The naming scheme for the inputs is as follows:  
"input" + <insert day#>  

In the javafiles you will find a folder called aoc22 that contains all of the java files for each of my solutions each with comments. The naming schemes for the java files:  
"AoC" + <insert day#>  

In the utilities folder you will find two folders:  
1.) aoc22  
2.) General  

In the aoc22 folder in the utilities folder you will find a bunch of java files. Each of these contain classes that were used in solving some of the problems. If a custom data type/class/object was used in the solution of a problem, it will most likely be found here.  

The second folder general has three files. The RUNDAY.java file and the DAYID.java files are a class and interface made by Nikhil Kumar, that essentially will compile each of the solutions and show the day, the answer to part 1, how long it took to run part 1, the answer to part 2, and how long it took to run part 2.  

The third file is called GetInputs.java, this is the file that must be changed in order for my code to run on another machine. The GetInputs file is an object made by Nikhil Kumar that allows access to the input for that specfic day and includes multiple useful methods to manipulate the input in order for parsing.  

The line that must be changed in order for the code to work on another computer will be found on line 16, it reads:  
file =  "C:\\Users\\nkh15448\\IdeaProjects\\AdventOfCode\\src\\inputs" + "\\input" + day + ".txt";  
The part that needs to be changed is simply this part:  
 "C:\\Users\\nkh15448\\IdeaProjects\\AdventOfCode\\src\\inputs"  
 What must be done is that this part of the string, must be replaced with the absolute path of the inputs folder, that is found in src, that is found in the project. Once replaced with the absolute path then the code should work.  
 
 In addition if you plan on uploading any of your personal inputs, they will work for majority of the solutions, however there may be one or two where it doesn't. That is because the code makes assumptions about the code based around my personal input, which isn't against the Advent of Code rules as it only requires you to produce the answer based on your personal input.  
 

      
