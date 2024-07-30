FROM openjdk:17-jdk-slim as build

MAINTAINER pathumpml.com

COPY build/libs/*.jar accounts.jar

ENTRYPOINT ["java", "-jar", "accounts.jar"]