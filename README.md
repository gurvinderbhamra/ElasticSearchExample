**ElasticSearchWithSpringBoot**

Accessing Elastic Search Instance from a Spring Boot application

**Pre-requisites**: 
To setup the application, following are the pre-requisites:
- JDK 1.8
- Elasticsearch 5.5.0 (set the cluster name in application.properties file as in your elasticsearch.yml)
- Maven 3.6.0

To run application locally, the command is:
- **mvn spring-boot:run**
- or you can directly execute the main function in **SpringDataElasticSearchApplication**.java

**API details:**
1. API to create or save user:
    `curl --header "Content-Type: application/json" --request POST --data '{"id":"3","name":"def","userSettings":{"gender":"male","hobbies":"xyz"}}' http://localhost:8080/user/create`
    
2. Get User by id:
     `curl -X GET http://localhost:8080/user/get/{id}`
     
3. Delete user by id:
     `curl -X DELETE http://localhost:8080/user/delete/{id}`
