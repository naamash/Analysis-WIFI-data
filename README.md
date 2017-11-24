**Date: 23/11/2017**  

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
Hadar Alon  
Naama Shtauber  

**Introduction**
==
**About the project**
--
This program gets a folder from user, takes only CSV files exported from an app called "Wigle WiFi" sorts them into one CSV file.   
The new file will contain all the WiFi networks from the CSV files arranged by their signals in an acsending order.  
Then it takes the new CSV file, filter the duplicated Macs, taking from each mac the strongest one and converts the file it to a KML file using JAK for writing the file.   
The KML file could then be uploaded to Google Earth.
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
pa - all the project's classes.  
wigle wifi - exported CSV files and some others to check the program's filter.  
```  
**About the classes:**  
--
* Check - calls a function `ChooseFilter.Decide()` in class `ChooseFilter`.  
* ChooseFilter - gets the user choice of filtering and a folder's path and sends to the functions that filter the files.  
* filters - filters the networks by the user's choice of time, device ID or location - checking if a point is withing the user's radius input.
* ReadAndSave - reads from the files to check if they are in the correct app format. Then sends the chosen files to be written into one CSV file.  
* HelpFilter - has functions that help filtering the files in class `filter`.  
* MacBig - creates an object that saves all the information to be written in the KML file.
* LineOfInfo - takes every line from the CSV files - the line contains a network information to help check those lines while filtering.
* FindIndex - gets a string and checks if it is withing the arrayList of lines.  
* Copying - mading the top ten values from each lat and lon with the highest RSSI and saves it.  
* ConvertToKml - converts the information to kml file.

**How to run the program**  
--
To start the project the user need to put the csv files in the given "wegle wifi" folder and then the user should push "run" in `check` class.  
The runing send to `ChooseFilter` class, such that the user being asked to write name folder and then to choose one kinde of filter.  

```
Scanner folderr = new Scanner((System.in));  
				System.out.println("enter folder name");  
				String foldername = folderr.nextLine();  
				File folder = new File(foldername);  
				ReadAndSave.readingFile(folder);  
```

