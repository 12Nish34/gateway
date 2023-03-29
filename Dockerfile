FROM maven:4.0.0-jdk-11-slim AS build
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean package


FROM openjdk:17

COPY target/*.jar /app.jar

ENTRYPOINT ["java","-jar","app.jar"]