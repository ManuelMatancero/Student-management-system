# Student-management-system
In this project I put in practice skills as JSP, Hibernate/JPA and other Java web technologies

# How to setup and run
First of all you have to install glassFish server 5.0 in your disk drive closer to the operating sistems in a folder you should create as AppServers.
After that you have to configure it, in the route folder C:\AppServers\glassfish5\glassfish\lib you have to download and add in this location the 
mysql-connector-j-8.0.31.jar that it going to allows you to conect to MySql, after that in ApacheNetbeans add the GlassFish Server version 5.0 or 5.0.1, 
going to services, servers and then add server, Netbeans is going to guide you througt the process.

# Database Schema
You have to have intalled MySQL and My SQL workbench and create a database called sga with the following structure

![sgaDB](https://user-images.githubusercontent.com/94880683/210022311-327a839a-a6a7-4123-92e8-441913bb97c4.png)

Remember that you should change the user and the password acording with the credentials of your MySql Workbench in the persistence.xml document 
in the project.
In case of having problems to run this project try to search on google the exception that trows you in the glass fish server cosole. I made this project with ApacheNetbeans
for this reason all this explanation was made according with this IDE.
