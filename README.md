1: download hibernate librarries from : https://luv2code.com/category/hibernate/

2: open required folder and copy the jar files

3: download mysql connector/j from  : https://dev.mysql.com/downloads/connector/j/

4: copy jar file 

5: create a java project and create a new folder name it : lib

6: paste all the jar file in the lib folder

7: right click on java project and open  : properties -> java build path -> libraries 

8: in libraries section click on add jar files and then add the jar files that are present in the lib folder

9: add hibernateconfig xml file in src directory.


When using Hibernate, if you log the Hibernate SQL statements, you will see this:

Hibernate: insert into student (email, first_name, last_name, id) values (?, ?, ?, ?)

To view parameter values, we can add a logging framework to our project. For this example, 
we will make use of the Logback project. Logback does not use any log4j source code. 
Logback is a separate and independent project.

10. Add Logback support to your project classpath

11. Create Logback configuration file

12. Run the CreateStudentDemo app
