# drjava-gmu

-   compiled with JDK 1.8
-   Latest Update: Fri Sep 25 13:45:44 EDT 2015

# Overview

This is an unofficial version of DrJava which has been modified from
the source code of the last stable release
(drjava-stable-20140826-r5761).  It fixes a few minor problems noticed
by George Mason University CS 211 and 310 students over the course of
the last year. GMU students are encouraged to use this version as it
will make unit test error reports easier to read and enable the java
debugger to be used through DrJava.

# Use

## Windows

On most recent windows systems one can "run" a jar file just by double
clicking on it. Download the `drjava.jar` file to a convenient
location and double click to start DrJava running.

## Windows Command Line

Ensure that a Java 1.8 runtime is installed on your system by opening
a command prompt (`cmd.exe`) and running the command

    java -version

You should see a version string like `1.8.0_31` which denotes
compatibility. Versions like `1.7.0_85` will likely not work.

<div class="center">
![img](windows-cmd.png)
</div>

Change to the directory where `drjava.jar` resides and run the command 

    java -jar drjava.jar

to start DrJava.

## Mac

On most recent Mac systems one can "run" a jar file just by double
clicking on it. Download the `drjava.jar` file to a convenient
location and double click to start DrJava running.

To run from the command line, follow the unix instructions below.

## Unix and Linux

Change to the directory where `drjava.jar` resides and run the command 

    java -jar drjava.jar

to start DrJava.

# Summary of changes

## Fri Sep 25 13:45:44 EDT 2015

-   Added options to change the color of passed/failed JUnit
    tests. Color options can be set in 
    
        Edit -> Preferences -> Display Options -> Colors

## Fri Aug 28 13:12:11 EDT 2015

-   Updates to JUnit test run output to include test names along with
    error locations to improve readability of results
-   Minor fix of switch statement to ensure that Debugger menu appears
    in main DrJava window when Java 8 is in use. Tested and functional
    on Windows 8.1 with JDK 1.8, Mac OS X 10.10 Yosemite with JDK 1.8,
    Linux with Open JDK 1.8.
-   Added command line argument `-log-all` to enable logging to be turned
    on at run time; changed Log file `ENABLE_ALL` from final variable to
    allow this.
