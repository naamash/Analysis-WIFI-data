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

This program contains 4 assignments :  
At matala(0+1) the program get a folder from user, takes only CSV files exported from an app called "Wigle WiFi" sorts them into one CSV file.   
The new file will contain all the WiFi networks from the CSV files arranged by their signals in an acsending order.  
Then it takes the new CSV file, filter the duplicated Macs, taking from each mac the strongest one and converts the file it to a KML file using JAK for writing the file.   
The KML file could then be uploaded to Google Earth.  

At matala2 the program realizing two algorithms -  
The first one get folder from user, takes only CSV files exported from an app called "Wigle WiFi" ,filter them and export the filter into one CSV after calculating Weighted average for every MAC with number of strongest samples(the user decide the number of samples).
The second algorithm get two folders from user: one with dataBase and the other one with less values.
The program search in the dataBase(for every line in the less file) same values(time,display and more). After that the program calculate Weighted average and put the correct and calculated answers of every line instead of the less value. 
At the end the program export new CSV file with the new values.

Matala 3 convert the project to GUI.  

Matala 4 let using SQL and Gradle.

**File List:**  
--
```
.:  
.settings  
src/main   
src/test      
boazFiles    
Gradle   
matala two    
matalaZeroFiles  
build.gradle    
README.md  
pom.xml  
```
```  
.settings - some eclipse settings files.
Jak - JAK files.  
doc - JavaDoc files.  
src/main - contains all the project's packages eccept Junits.  
src/test - contains all the Junits.
matalaZeroFiles, matala two and data- exported CSV files and some others to check the program's filter.  
boazFiles - contain the dataBase(the user can editing this folder-to add more files or delete some of them).
matala two - contain the files with the lesses values(the user can editing this folder-to add more files or delete some of them).  
build.gradle - gradle.  

```  
**About the packages:**  
--  
* test - contains all of the Junits we made for this program.
* algo1and2 - contain the mains functions of matala2. 
* filtersPack - contain the classes that filters the networks by the user's choice of time, device ID or location - checking if a point is withing the user's radius input.
* objects - contain all of the objects we made for this project.
* writeTo - contain the classes that actually convert files to KML and to CSV.
* mainClass - contain the main. (the user have to decide matala0+1 or matala2).
* GUI - contains the main functions that actually build the GUI.  

 

**How to run the program**  
--  
Run the GUI.  
In GUI the user have to choose file or folder or SQL (the user can add more dataBase or clear the dataBase).  
Then, the user can choose to apply algo1 or algo2 on the database.  
He can also filter the dataBase as his wish while choosing the filter on the options in menu on the top.  
The user can also export the dataBase to KML or to CSV as his wish.


In matala0+1:  
--  
To start the project the user need to put the csv files in the given "matalZeroFiles" folder and then the user should push "run" in `check` class(after choosing matala0+1).  
The running send to `ChooseFilter` class, such that the user being asked to write name folder and then to choose one kind of filter. 

in matala2:  
--  
To start the project the user need to put the dataBase files in the given "boazFiles" folder and the lesses files in the given "matala two" folder.
 
*IN BOTH OF THEM THE USER WILL BE ASKED TO WRITE LOCATHIN SO THAT THE OUTPUTS WILL BE SAVED THERE*  

In GUI:  
--
Only run as GUI.
*The user enter his choices in the GUI window*

```
Scanner folderr = new Scanner((System.in));  
				System.out.println("enter folder name");  
				String foldername = folderr.nextLine();  
				File folder = new File(foldername);  
				ReadAndSave.readingFile(folder);  
```

