FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9080
ARG JAR_FILE=target/theretailstore-0.0.1.jar
COPY ${JAR_FILE} retailstore.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/retailstore.jar"]
