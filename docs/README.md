# Duke User Guide

Dukeis a desktop app for people to manage their tasks, optimized for use via Command Line Interface (CLI).

## Quick Start : Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Install Java 11 on your computer.
2. Download the latest version of Duke,jar and open it with java -jar Duke.jar.
3. If you want to use existing data, create a “data” directory and copy the data file to it, name the data file as “data.txt.
4. If the setup was done correctly, you should see something like the logo below:
   ```
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   ```
4.Use the help command to see the available commands.
5.Refer to the Features section below for details of each command.


## Features

````
Notes:
Words in capital letters are parameters to be supplied by users.
````


###Viewing help: `help`
Show all the possible commands.

Format: `help`


###Adding a "todo" task: `todo`
Adds a task to the list of task, involving only a description

Format: `todo DESCRIPTION` 

###Adding a "Deadline" task: `deadline` 
Adds a deadline task to the list, involving a description and time input

Format: `deadline DESCRIPTION /DATE TIME`

Date format is DD-MM-YY. 
Time format is in 24-hrs, written as a single timing. 

Example: 
`deadline`IP /20-09-20 1800

###Adding a "event" task: `event`
Adds an event task to the list, involving a description and time input

Format: `event DESCRIPTION /DATE TIME`

Date format is DD-MM-YY. 
Time format is in 24-hrs, can be a time interval or a single timing.
Time interval is separated by “-”.

Example:
`add` Presentation /10-10-20 t/1200-1400


###Deleting a task: `delete`
Deletes a specified task.

Format: `delete INDEX`

Example:
delete 2
Delete 2nd task in the list.


###Set a task as done: `done` 
Sets a chosen tasks as done.

Format: `done INDEX`

Example:
display
done 2
Marks 2nd task in list as done


###Searching for tasks: `search`
Search through the task list with given keyword(s) and display relevant tasks. The keyword can be multiple words 

Format: `search KEYWORD`

Example:
search homework
Find task(s) with a description that contains homework


###Exiting the program: `bye`
Exits the app.

Format: `bye`





