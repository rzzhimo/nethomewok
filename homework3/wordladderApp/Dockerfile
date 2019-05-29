FROM openjdk:8-jdk-alpine

VOLUME /tmp
COPY target/*.jar app.jar
ADD dict.txt dict.txt
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8086