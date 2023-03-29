FROM maven:3.8.6-openjdk-11 AS build
COPY pom.xml .
COPY src /src


FROM openjdk:17
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["run.sh"]