ToDo List project backend
=====
## The manual for deploying and configuring the application locally

1. Clone repo from GitHub on your local machine.
2. It is necessary that the JRE (Java Runtime Environment) was installed on the working machine.
3. All necessary dependencies are written in pom.xml file. 
4. Click Build and then Run to start the application

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


## Current Version
- Fixed tag editing and deleting
- Fixed task editing request

 

