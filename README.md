ToDo List project backend
=====
## The manual for deploying and configuring the application locally

-The application will be delivered as a jar archive.
-It is necessary that the JRE (Java Runtime Environment) was installed on the working machine.
-To run the application type in the command line:
"java -Duser.timezone=GMT -jar <name of the file with the extension .jar>"
-All done, you've launched the application!

## The logic of the application
The java application was written on Java using the framework Spring. It consists of a few layers (java packages):
1. Dao Package
The layer to work with database entities
2. Repository
The layer which implements internal work of Spring framework to get data from database
3. Dto
Intermediate layer to connect database with service layer
4. Service 
The service package is necessary to implements internal logic of the application and the relationship between user's requests and database
5. Controller
The layer for all possible CRUD request

A link to the PostMan request collection is attached below
Click import button and paste it to run collection
https://www.getpostman.com/collections/5f0cdeb73311e723c93f




 

