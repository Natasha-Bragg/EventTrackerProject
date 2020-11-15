# Event Tracker Project- New Parent Application

### Overview

Students were asked to build a full stack web application that encompassed a REST API Controller design with full C.R.U.D capability. The project was to use a database that we built from the ground up. We were to create controller logic to perform the basic CRUD operations of a REST API. These routes were tested using Postman. This application has being deployed to AWS.
This application is used for new parents to be able to keep track of a new babies day to day activities feeds, changes, sleep, naps ect.

### Technologies and Methodologies Used

* REST API controller(s), service, and Spring Data JPA repository.
* Postman
* Amazon EC2
* GitHub
* Object Relational Mapping
* Data Manipulation and Transactions
* SQL Data Manipulation Language using JDBC
* JSP Views
* JSP Expression language
* Tag libraries
* JavaBeans
* Database Accessor Objects
* Spring Web Model View Controller patterns
* Spring MVC with C.R.U.D
* HTML and CSS
* Gradle
* MySql Workbench

### Description
Refer to the list below for possible functionalities of the site.

 * The user is able to see all babies in their tracker app.
 * The user can see a specific baby by their ID.
 * The user can add a baby to the app.
 * The user can update a baby in the database.
 * The user can delete a baby from the database.


### Expected Routes

| Return Type   | Route                 | Functionality                  |
|---------------|-----------------------|--------------------------------|
| `List<Baby>`  |`GET api/baby`         | Gets all babies                |
| `Baby`        |`GET api/baby/{id}`    | Gets one baby by id            |
| `Baby`        |`POST api/baby`        | Creates a new baby             |
| `Baby`        |`PUT api/baby/{id}`    | Replaces an existing baby by id|
| `void`        |`DELETE api/baby/{id}` | Deletes an existing baby by id |
