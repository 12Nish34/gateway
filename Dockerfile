FROM maven:4.0.0-jdk-11-slim AS build
COPY pom.xml /home/app/
COPY src /home/app/src
RUN mvn -f /app/pom.xml clean package


FROM openjdk:17

COPY /home/app/target/order-service-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar

ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]