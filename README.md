# trade-store

## What's inside 
This project is based on the [Spring Boot](http://projects.spring.io/spring-boot/) project and uses these packages :
- Gradle
- Spring Core
- Spring Data (Hibernate & MySQL)
- Spring Boot (Tomcat)
- Swagger

## Installation 
The project is created with Gradle, so you just need to import it to your IDE and build the project to resolve the dependencies

## Database configuration 
Create a MySQL database with the name `bootdb` and add the credentials to `/resources/application.properties`.  
The default ones are :

```
spring.datasource.url=jdbc:mysql://localhost/bootdb?createDatabaseIfNotExist=true&autoReconnect=true&allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=root
```

## Usage 
Run the project through the IDE and head out to [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
