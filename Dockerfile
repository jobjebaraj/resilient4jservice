FROM openjdk:22
ADD  target/spring-docker-demo.jar spring-docker-demo.jar
ENTRYPOINT ["java" , "-jar",  "spring-docker-demo.jar"]






