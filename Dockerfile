FROM openjdk:8
RUN apt-get update && apt-get upgrade -y
ADD /target/technical-assessment-0.0.1-SNAPSHOT.jar technical-assessment-0.0.1-SNAPSHOT.jar
EXPOSE 8586
ENTRYPOINT ["java", "-jar", "technical-assessment-0.0.1-SNAPSHOT.jar"]
