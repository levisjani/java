## **EJB - Access Database**

EJB 3.0, persistence mechanism is used to access the database in which container manages the database related operations. Developers can access database using jdbc api call directly in ejb business methods.

To demonstrate database access in ejb,the following tasks are:

- _Step 1_. Create table in database.

- _Step 2._ Create a stateless ejb having business me.

- _Step 3._ Update stateless ejb. Add methods to add records and get records from database via entity manager.

- _Step 4._ A console based application client will access the stateless ejb to persist data in database.





## **Example Application**

### Description

- Create a project with a name EjbComponent under a package com.tutorialspoint.entity as explained in the EJB - Create Application chapter. You can also use the project created in EJB - Create Application chapter as such for this chapter to understand ejb data access concepts.
- Create Book.java under package com.tutorialspoint.entity and modify it as shown below.
- Create LibraryPersistentBean.java and LibraryPersistentBeanRemote as explained in the EJB - Create Application chapter and modify them as shown below.
- Clean and Build the application to make sure business logic is working as per the requirements.
- Finally, deploy the application in the form of jar file on JBoss Application Server. JBoss Application server will get started automatically if it is not started yet.
- Now create the ejb client, a console based application in the same way as explained in the EJB - Create Application chapter under topic Create Client to access EJB. Modify it as shown below.
