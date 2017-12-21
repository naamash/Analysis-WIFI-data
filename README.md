**Date: 21/12/2017**  

Task 1 - Object Oriented
===
KmlAndCsv-files
==
*Project Source can be downloaded from:* 
-- 
https://github.com/hadaral/KmlAndCsv-files.git  
This program is part of Ariel University Object's Oriented course.  

Authors:
---
Hadar Alon - 205749211
Naama Shtauber - 316162114  

**Introduction**
==
**About the project**
--

This program contains two assignments :  
At matala(0+1) the program get a folder from user, takes only CSV files exported from an app called "Wigle WiFi" sorts them into one CSV file.   
The new file will contain all the WiFi networks from the CSV files arranged by their signals in an acsending order.  
Then it takes the new CSV file, filter the duplicated Macs, taking from each mac the strongest one and converts the file it to a KML file using JAK for writing the file.   
The KML file could then be uploaded to Google Earth.  

At matala2 the program realizing two algorithms -  
The first one get folder from user, takes only CSV files exported from an app called "Wigle WiFi" ,filter them and export the filter into one CSV after calculating Weighted average for every MAC with number of strongest samples(the user decide the number of samples).
The second algorithm get two folders from user: one with dataBase and the other one with less values.
The program search in the dataBase(for every line in the less file) same values(time,display and more). After that the program calculate Weighted average and put the correct and calculated answers of every line instead of the less value. 
At the end the program export new CSV file with the new values.

**File List:**  
--
```
.:  
.settings  
Jak  
doc    
pa  
wigle wifi 
.classpath  
.gitignore
.project  
README.md  
pom.xml  
```
```
.settings - some eclipse settings files.
Jak - JAK API files.  
doc - JavaDoc files.  
code - all the project's packages.  
matalaZeroFiles - exported CSV files and some others to check the program's filter.  
boazFiles - contain the dataBase(the user can editing this folder-to add more files or delete some of them).
matala two - contain the files with the lesses values(the user can editing this folder-to add more files or delete some of them).

```  
**About the packages:**  
--  
* test - contains all of the Junits we made for this program.
* algo1and2 - contain the mains functions of matala2. 
* filters - contain the classes that filters the networks by the user's choice of time, device ID or location - checking if a point is withing the user's radius input.
* objects - contain all of the objects we made for this project.
* write to - contain the classes that actually convert files to KML and to CSV.
* mainClass - contain the main. (the user have to decide matala0+1 or matala2).

 

**How to run the program**  
--  
The user can choose : matala0+1 or matala2.

In matala0+1:  
--  
To start the project the user need to put the csv files in the given "matalZeroFiles" folder and then the user should push "run" in `check` class(after choosing matala0+1).  
The running send to `ChooseFilter` class, such that the user being asked to write name folder and then to choose one kind of filter. 

in matala2:  
--  
To start the project the user need to put the dataBase files in the given "boazFiles" folder and the lesses files in the given "matala two" folder.
 
*IN BOTH OF THEM THE USER WILL BE ASKED TO WRITE LOCATHIN SO THAT THE OUTPUTS WILL BE SAVED THERE*  


```
Scanner folderr = new Scanner((System.in));  
				System.out.println("enter folder name");  
				String foldername = folderr.nextLine();  
				File folder = new File(foldername);  
				ReadAndSave.readingFile(folder);  
```

