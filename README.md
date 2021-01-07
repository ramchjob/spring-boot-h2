# Spring-boot-h2 Swagger
In this example I have used H2 as in memory database and rest web services are exposed via Swagger-UI.
Project can be executed as follows: 

 - mvn clean
 - mvn install
 - mvn spring-boot:run

After the project is up and running DB, Services and Swagger-UI can be accessed as follows:

 - DB
	 - Access localhost:8080/h2-console     with schema jdbc:h2:mem:testdb  connect and see tables data.
 
 - Services

	 - Department
		 - GET  localhost:8080/dept
	 	 - GET  localhost:8080/dept/{deptno}
		 - POST localhost:8080/dept
		 - PUT  localhost:8080/dept
		 - DELETE localhost:8080/dept/{deptno}	

	 - Employee
		 - GET  localhost:8080/emp
		 - GET  localhost:8080/emp/{empno}
		 - DELETE localhost:8080/emp/{empno} 
		 
 - Swagger-UI
	 - localhost:8080/swagger-ui.html
