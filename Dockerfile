FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} structure-service.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb1/structure_db","-jar","/structure-service.jar"]
EXPOSE 9001