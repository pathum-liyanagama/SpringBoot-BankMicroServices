FROM openjdk:17-jdk-slim as build

MAINTAINER pathumpml.com

COPY build/libs/*.jar loans.jar

ENTRYPOINT ["java", "-jar", "loans.jar"]