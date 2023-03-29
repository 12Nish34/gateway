FROM maven:3.8.6-openjdk-11 AS build
COPY pom.xml .
COPY src /src


FROM openjdk:17

COPY --from=build target/*.jar app.jar
ENTRYPOINT ["run.sh"]