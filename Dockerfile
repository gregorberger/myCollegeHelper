FROM openjdk:latest

ADD target/warFile.war warFile.war
ENTRYPOINT ["java", "-jar", "/warFile.war"]
EXPOSE 8080