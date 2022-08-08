FROM openjdk:11-jdk-slim
MAINTAINER ITAcademy

COPY target/VotingService-1.0.0.jar VotingService-1.0.0.jar

ENTRYPOINT ["java", "-jar", "/VotingService-1.0.0.jar"]